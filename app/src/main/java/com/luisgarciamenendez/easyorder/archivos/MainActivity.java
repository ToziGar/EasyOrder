package com.luisgarciamenendez.easyorder.archivos;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.luisgarciamenendez.easyorder.archivos.Database.UsuarioDBHelper;
import com.luisgarciamenendez.easyorder.archivos.EditarProductos.CrearProductoDialog;
import com.luisgarciamenendez.easyorder.archivos.EditarProductos.EditarProductoItemFragment;
import com.luisgarciamenendez.easyorder.archivos.ListaDePedidos.PedidoItemFragment;
import com.luisgarciamenendez.easyorder.archivos.Utilidades.InfoDialog;
import com.luisgarciamenendez.easyorder.archivos.NuevoPedido.ProductoItemFragment;
import com.luisgarciamenendez.easyorder.archivos.NuevoPedido.MesaDialog;
import com.luisgarciamenendez.easyorder.archivos.StockProductos.ProductoStockItemFragment;
import com.luisgarciamenendez.easyorder.archivos.DBManager.DBManager;
import com.luisgarciamenendez.easyorder.archivos.DBWrappers.OrderContainer;
import com.luisgarciamenendez.easyorder.archivos.DBWrappers.DishesContainer;



import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.luisgarciamenendez.easyorder.archivos.DBManager.DBManager.SELECTED_COL_ID_ORDER;
import static com.luisgarciamenendez.easyorder.archivos.DBManager.DBManager.SELECTED_TABLE;
import static com.luisgarciamenendez.easyorder.archivos.NuevoPedido.ProductoItemFragment.ListaProductos;
import static com.luisgarciamenendez.easyorder.archivos.NuevoPedido.ProductoRecyclerViewAdapter.ListaCantidad;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, ProductoItemFragment.OnListFragmentInteractionListener,
        PedidoItemFragment.OnListFragmentInteractionListener, EditarProductoItemFragment.OnListFragmentInteractionListener,
        ProductoStockItemFragment.OnListFragmentInteractionListener {

    private Toolbar toolbar;
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;
    private FloatingActionButton fab;
    private int actualFragment;
    private ProductoItemFragment productoItemFragment;
    private EditarProductoItemFragment editarProductoItemFragment;
    private TextView titleTv;
    private TextView emailTv;
    private LinearLayout linearLayout;
    private final int NEW_ORDER_FRAGMENT = 1;
    public static final int EDIT_DISHES_FRAGMENT = 2;
    private final int LIST_ORDERS_FRAGMENT = 3;
    private final int DISHES_STOCK_FRAGMENT = 4;
    private final int SETTINGS_FRAGMENT = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        visibilidad();
        initVisuals();
        if (getIntent().hasExtra("Fragment")) toolbar.setTitle("Editar productos");
        else toolbar.setTitle("Nuevo pedido");
        setSupportActionBar(toolbar);
        setFloatingButtonClickListener();



        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        configNavigationHeaderView();

        if (isFirstLaunch()) {
            manageFirstLaunch();
        } else {
            if (getIntent().hasExtra("Fragment")) {
                Bundle b = getIntent().getExtras();
                if (b.getInt("Fragment") == EDIT_DISHES_FRAGMENT) {
                    actualFragment = EDIT_DISHES_FRAGMENT;
                    configureFab(EDIT_DISHES_FRAGMENT);
                    editarProductoItemFragment = new EditarProductoItemFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.mainLayout, editarProductoItemFragment).commit();
                }
            } else {
                manageDefaultStart();
            }
        }
    }

    private void visibilidad() {
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        Menu menu = navigationView.getMenu();

        for (int menuItemIndex = 0; menuItemIndex < menu.size(); menuItemIndex++) {
            MenuItem menuItem = menu.getItem(menuItemIndex);

            SharedPreferences prefs = this.getSharedPreferences("datos", Context.MODE_PRIVATE);
            String RecuperarEmail = prefs.getString("mail", "");

            UsuarioDBHelper admin = new UsuarioDBHelper(this, "usuarios.db", null, 1);
            SQLiteDatabase db = admin.getReadableDatabase();

            Cursor fila = db.rawQuery("select * from usuarios where email ='" + RecuperarEmail +"'", null);

            if (fila.moveToFirst() == true) {
                String email = fila.getString(0);
                String pass = fila.getString(1);
                String tipo = fila.getString(2);

                if (tipo.equals("Usuario")) {
                    if (menuItem.getItemId() == R.id.nav_nuevo_pedido) {
                        menuItem.setVisible(true);
                    }
                    if (menuItem.getItemId() == R.id.nav_configuracion) {
                        menuItem.setVisible(true);
                    }
                    if (menuItem.getItemId() == R.id.nav_ayuda) {
                        menuItem.setVisible(true);
                    }
                }
                if (tipo.equals("Camarero")) {
                    if (menuItem.getItemId() == R.id.nav_nuevo_pedido) {
                        menuItem.setVisible(true);
                    }
                    if (menuItem.getItemId() == R.id.nav_configuracion) {
                        menuItem.setVisible(true);
                    }
                    if (menuItem.getItemId() == R.id.nav_ayuda) {
                        menuItem.setVisible(true);
                    }
                    if (menuItem.getItemId() == R.id.nav_lista_pedidos) {
                        menuItem.setVisible(true);
                    }
                    if (menuItem.getItemId() == R.id.nav_stock_productos) {
                        menuItem.setVisible(true);
                    }
                }
                if (tipo.equals("Administrador")) {

                    if (menuItem.getItemId() == R.id.nav_nuevo_pedido) {
                        menuItem.setVisible(true);
                    }
                    if (menuItem.getItemId() == R.id.nav_configuracion) {
                        menuItem.setVisible(true);
                    }
                    if (menuItem.getItemId() == R.id.nav_ayuda) {
                        menuItem.setVisible(true);
                    }
                    if (menuItem.getItemId() == R.id.nav_lista_pedidos) {
                        menuItem.setVisible(true);
                    }
                    if (menuItem.getItemId() == R.id.nav_stock_productos) {
                        menuItem.setVisible(true);
                    }
                    if (menuItem.getItemId() == R.id.nav_editar_productos) {
                        menuItem.setVisible(true);
                    }
                }
            }
        }
    }

    private void initVisuals() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        View header = navigationView.getHeaderView(0);
        titleTv = (TextView) header.findViewById(R.id.navDrawerTitle);
        emailTv = (TextView) header.findViewById(R.id.navDrawerEmail);
        linearLayout = (LinearLayout) header.findViewById(R.id.navBackground);
        navigationView.setItemIconTintList(null);
    }

    private void setFloatingButtonClickListener() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (actualFragment) {
                    case NEW_ORDER_FRAGMENT:
                        if (productoItemFragment.checkIfPriceIsZero()) {
                            showNoProductsSelectedDialog();
                        } else {
                            showTableDialog();
                        }
                        break;
                    case EDIT_DISHES_FRAGMENT:
                        showCreateDishDialog();
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private void showNoProductsSelectedDialog() {
        Bundle b = new Bundle();
        b.putString("Type", "No hay productos seleccioandos");
        InfoDialog infoDialog = new InfoDialog();
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        infoDialog.setStyle(DialogFragment.STYLE_NO_TITLE, 0);
        infoDialog.setArguments(b);
        infoDialog.show(fragmentManager, "tag");
    }

    private void showTableDialog() {
        MesaDialog mesaDialog = new MesaDialog();
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        mesaDialog.setStyle(DialogFragment.STYLE_NO_TITLE, 0);
        mesaDialog.setOnTableDialogResultListener(new MesaDialog.OnTableDialogResultListener() {
            @Override
            public void onPositiveResult(int numTable) {
                double price = productoItemFragment.getProductoRecyclerViewAdapter().getTotalPrice();
                SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
                Date date = new Date();
                String dateStr = df.format(date);
                DBManager.getInstance(getApplicationContext()).insertOrder(price, dateStr, numTable);
                OrderContainer.refresh(getApplicationContext());
                ListaProductos.clear();
                ListaCantidad.clear();
                productoItemFragment.updateStockDb();
                DishesContainer.refresh(getApplicationContext());
                productoItemFragment.getProductoRecyclerViewAdapter().resetView();
                insertar();
                Toast.makeText(getApplicationContext(), "El pedido se ha realizado", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNegativeResult() {
                //Do nothing
            }
        });
        mesaDialog.show(fragmentManager, "tag");
    }


    private void insertar() {
        final String[] ProductosArray = new String[ListaCantidad.size()];
        DBManager dbManager = new DBManager(this);
        SQLiteDatabase db = dbManager.getWritableDatabase();
        int id_orden = 0;
        int id_producto = 0;

        Cursor ordenes = db.rawQuery("select * from Orders", null);
        ordenes.moveToLast();
        id_orden = ordenes.getInt(ordenes.getColumnIndex("id"));

        for (int i = 0; i < ListaCantidad.size(); i++) {
            ProductosArray[i] = "x" + ListaCantidad.get(i) + "  " + ListaProductos.get(i);
            Cursor productos = db.rawQuery("select * from Products WHERE name = ?;", new String[]{ListaProductos.get(i)});
            if (productos.moveToFirst() == true) {
                id_producto = productos.getInt(ordenes.getColumnIndex("id"));
            }
            ContentValues insertValues = new ContentValues();
            insertValues.put("name", ListaProductos.get(i));
            insertValues.put("quantity", Integer.valueOf(ListaCantidad.get(i)));
            insertValues.put("id_products", id_producto);
            insertValues.put("id_order", id_orden);
            db.insert("Selected", null, insertValues);
        }
    }


    public void showCreateDishDialog() {
        CrearProductoDialog crearProductoDialog = new CrearProductoDialog();
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        crearProductoDialog.setStyle(DialogFragment.STYLE_NO_TITLE, 0);
        crearProductoDialog.setOnCreatePlatDialogResultListener(new CrearProductoDialog.OnCreatePlatDialogResultListener() {
            @Override
            public void onPositiveResult(Bundle bundle) {
                String name = bundle.getString("name");
                double price = bundle.getDouble("price");
                int stock = bundle.getInt("stock");
                String imgUri = bundle.getString("imgUri");
                DBManager.getInstance(getApplicationContext()).insertDish(imgUri, price, name, stock);
                DishesContainer.refresh(getApplicationContext());
                editarProductoItemFragment.refreshAdapter(DishesContainer.getInstance(getApplicationContext()).getDishList());
            }

            @Override
            public void onNegativeResult() {
            }
        });
        crearProductoDialog.show(fragmentManager, "tag");
    }

    private void configNavigationHeaderView() {
        SharedPreferences prefs = this.getSharedPreferences("datos", Context.MODE_PRIVATE);
        String RecuperarNombre = prefs.getString("name", "");
        String RecuperarEmail = prefs.getString("mail", "");
        String backgroundUri = prefs.getString("BackgroundUri", "");
        titleTv.setText(RecuperarNombre);
        emailTv.setText(RecuperarEmail);
        if (!backgroundUri.equals("")) {
            Uri uri = Uri.parse(backgroundUri);
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                linearLayout.setBackground(bitmapDrawable);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isFirstLaunch() {
        SharedPreferences prefs = this.getSharedPreferences("datos", Context.MODE_PRIVATE);
        return prefs.getBoolean("FirstLaunch", true);
    }

    private void manageFirstLaunch() {
        SharedPreferences prefs = this.getSharedPreferences("datos", Context.MODE_PRIVATE);
        prefs.edit().putBoolean("FirstLaunch", false).apply();
        DishesContainer.initInstanceWithStubs(getApplicationContext());
        OrderContainer.initInstanceWithStubs(getApplicationContext());
        setToolbarTitle("Ayuda");
        configureFab(SETTINGS_FRAGMENT);
        AyudaFragment f = new AyudaFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.mainLayout, f).commit();
    }

    private void setToolbarTitle(String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
    }

    private void manageDefaultStart() {
        actualFragment = NEW_ORDER_FRAGMENT;
        configureFab(NEW_ORDER_FRAGMENT);
        productoItemFragment = new ProductoItemFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.mainLayout, productoItemFragment).commit();
    }

    private void configureFab(int fragmentTag) {
        switch (fragmentTag) {
            case NEW_ORDER_FRAGMENT:
                fab.setImageDrawable(getResources().getDrawable(R.mipmap.ic_done_white_64dp_1x));
                fab.setVisibility(View.VISIBLE);
                break;
            case EDIT_DISHES_FRAGMENT:
                fab.setImageDrawable(getResources().getDrawable(R.mipmap.ic_add_white_48dp));
                fab.setVisibility(View.GONE);
                break;
            case LIST_ORDERS_FRAGMENT:
                fab.setVisibility(View.GONE);
                break;
            case DISHES_STOCK_FRAGMENT:
                fab.setVisibility(View.GONE);
                break;
            case SETTINGS_FRAGMENT:
                fab.setVisibility(View.GONE);
                break;
        }
        actualFragment = fragmentTag;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_nuevo_pedido) {
            showNewOrderFragment();
        } else if (id == R.id.nav_editar_productos) {
            showEditDishes();
        } else if (id == R.id.nav_lista_pedidos) {
            showListOrdersFragments();
        } else if (id == R.id.nav_stock_productos) {
            showDishesStockFragment();
        } else if (id == R.id.nav_configuracion) {
            startActivity(new Intent(MainActivity.this, ConfiguracionActivity.class));
        } else if (id == R.id.nav_ayuda) {
            showHelpFragment();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showNewOrderFragment() {
        setToolbarTitle("Nuevo pedido");
        configureFab(NEW_ORDER_FRAGMENT);
        productoItemFragment = new ProductoItemFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.mainLayout, productoItemFragment).commit();

    }

    private void showEditDishes() {
        setToolbarTitle("Editar productos");
        configureFab(EDIT_DISHES_FRAGMENT);
        editarProductoItemFragment = new EditarProductoItemFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.mainLayout, editarProductoItemFragment).commit();
    }

    private void showListOrdersFragments() {
        setToolbarTitle("Lista de pedidos");
        configureFab(LIST_ORDERS_FRAGMENT);
        PedidoItemFragment pedidoItemFragment = new PedidoItemFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.mainLayout, pedidoItemFragment).commit();
    }

    private void showDishesStockFragment() {
        setToolbarTitle("Stock de los productos");
        configureFab(DISHES_STOCK_FRAGMENT);
        ProductoStockItemFragment f = new ProductoStockItemFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.mainLayout, f).commit();
    }

    private void showHelpFragment() {
        setToolbarTitle("Ayuda");
        configureFab(SETTINGS_FRAGMENT);
        AyudaFragment f = new AyudaFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.mainLayout, f).commit();
    }

    @Override
    public void onListFragmentInteraction(DishesContainer.Dish dish) {
        Toast.makeText(getApplicationContext(), "Producto sin existencias", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onListFragmentInteraction(OrderContainer.Order order) {

    }
}
