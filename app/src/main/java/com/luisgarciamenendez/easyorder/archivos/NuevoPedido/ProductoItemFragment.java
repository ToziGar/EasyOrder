package com.luisgarciamenendez.easyorder.archivos.NuevoPedido;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.luisgarciamenendez.easyorder.archivos.IntorduceCantidadDialog;
import com.luisgarciamenendez.easyorder.archivos.R;
import com.luisgarciamenendez.easyorder.archivos.DBManager.DBManager;
import com.luisgarciamenendez.easyorder.archivos.DBWrappers.DishesContainer;
import com.luisgarciamenendez.easyorder.archivos.Utilidades.InfoDialog;
import com.luisgarciamenendez.easyorder.archivos.Utilidades.ItemFragmentUtils;
import java.util.ArrayList;
import java.util.List;


public class ProductoItemFragment extends ItemFragmentUtils {

    public static ArrayList<String> ListaProductos = new ArrayList<String>();


    private OnListFragmentInteractionListener mListener;
    private ProductoRecyclerViewAdapter productoRecyclerViewAdapter;

    public ProductoItemFragment() {
        //Required empty constructor
    }

    public ProductoRecyclerViewAdapter getProductoRecyclerViewAdapter() {
        return productoRecyclerViewAdapter;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);
        if (view instanceof RecyclerView) {
            super.context = view.getContext();
            super.recyclerView = (RecyclerView) view;
            manageRecyclerViewLayout();
            setRecyclerViewAdapter();
        }
        return view;
    }

    private void setRecyclerViewAdapter() {
        productoRecyclerViewAdapter = new ProductoRecyclerViewAdapter(mListener, getContext());
        recyclerView.setAdapter(productoRecyclerViewAdapter);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        registerForContextMenu(recyclerView);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.nuevo_pedido_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_info) {
            showInfoDialog();
        } else if(id == R.id.menu_reset_comanda){
            productoRecyclerViewAdapter.resetView();
        }
        return super.onOptionsItemSelected(item);
    }

    private void showInfoDialog() {
        InfoDialog infoDialog = new InfoDialog();
        android.support.v4.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        infoDialog.setStyle(DialogFragment.STYLE_NO_TITLE, 0);
        Bundle bundle = makeInfoDialogBundle();
        infoDialog.setArguments(bundle);
        infoDialog.show(fragmentManager, "tag");
    }

    private Bundle makeInfoDialogBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("Type", "See price");
        bundle.putDouble("price", productoRecyclerViewAdapter.getTotalPrice());
        return bundle;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.nuevo_pedido_context, menu);
    }

    /** Menú que aparece en el nuevo comando después de hacer un clic largo en un producto **/
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        ProductoRecyclerViewAdapter.DishViewHolder dishViewHolder = getlastClickedViewHolder();

        switch (item.getItemId()) {
            case R.id.contextualMenuDecrease:
                dishViewHolder.decreaseQuantityByOne();
                break;
            case R.id.contextualMenuSetZero:
                dishViewHolder.decreaseQuantityToZero();
                break;
            case R.id.contextualMenuSetCustomNumber:
                showIntroduceQuantityDialog(dishViewHolder);
                break;
        }
        return super.onContextItemSelected(item);

    }

    public ProductoRecyclerViewAdapter.DishViewHolder getlastClickedViewHolder() {
        ProductoRecyclerViewAdapter.DishViewHolder dishViewHolder = null;
        try {
            dishViewHolder = productoRecyclerViewAdapter.getLastClickedView();
        } catch (Exception e) {
            Log.d("EXCEPTION", e.getLocalizedMessage(), e);
        }
        return dishViewHolder;
    }

    private void showIntroduceQuantityDialog(ProductoRecyclerViewAdapter.DishViewHolder dishViewHolder) {
        IntorduceCantidadDialog intorduceCantidadDialog = new IntorduceCantidadDialog();
        android.support.v4.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        intorduceCantidadDialog.setStyle(DialogFragment.STYLE_NO_TITLE, 0);
        setResultListenerIntrQuantDialog(intorduceCantidadDialog, dishViewHolder);
        intorduceCantidadDialog.show(fragmentManager, "tag");
    }

    private void setResultListenerIntrQuantDialog(IntorduceCantidadDialog intorduceCantidadDialog, final ProductoRecyclerViewAdapter.DishViewHolder dishViewHolder) {
        intorduceCantidadDialog.setOnDialogResultListener(new IntorduceCantidadDialog.OnDialogResultListener() {
            @Override
            public void onPositiveResult(int value) {
                if (dishViewHolder.isStockSufficient(value)){
                    dishViewHolder.setExactQuantity(value);

            } else {
                    Toast.makeText(getActivity().getApplicationContext(), "Producto sin stock suficiente", Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onNegativeResult() {
            }
        });
    }

    public boolean checkIfPriceIsZero(){
        return (productoRecyclerViewAdapter.getTotalPrice() == 0);
    }


    public void updateStockDb(){
        List<DishesContainer.Dish> dishList = productoRecyclerViewAdapter.getUpdatedDishes();
        for (DishesContainer.Dish dish : dishList){
            DBManager.getInstance(getActivity().getApplicationContext()).updateDish(dish.name, dish.stock);

            ListaProductos.add(dish.name);

        }
    }



    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(DishesContainer.Dish dish);
    }
}
