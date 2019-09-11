package com.luisgarciamenendez.easyorder.archivos.ListaDePedidos;



import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.luisgarciamenendez.easyorder.archivos.DBManager.DBManager;
import com.luisgarciamenendez.easyorder.archivos.ListaDePedidos.PedidoItemFragment.OnListFragmentInteractionListener;
import com.luisgarciamenendez.easyorder.archivos.R;
import com.luisgarciamenendez.easyorder.archivos.DBWrappers.OrderContainer;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static com.luisgarciamenendez.easyorder.archivos.NuevoPedido.ProductoItemFragment.ListaProductos;
import static com.luisgarciamenendez.easyorder.archivos.NuevoPedido.ProductoRecyclerViewAdapter.ListaCantidad;


public class PedidoItemRecyclerViewAdapter extends RecyclerView.Adapter<PedidoItemRecyclerViewAdapter.ViewHolder> {

    private final List<OrderContainer.Order> orderList;
    private final OnListFragmentInteractionListener mListener;
    private List<ViewHolder> viewHolderList;
    private Context context;


    public double getTotalPrice() {
        double price = 0;
        for (ViewHolder holder : viewHolderList) {
            price += holder.order.price;
        }
        return price;
    }

    public PedidoItemRecyclerViewAdapter(List<OrderContainer.Order> items, OnListFragmentInteractionListener listener) {
        orderList = items;
        mListener = listener;
        viewHolderList = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_pedidositem, parent, false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        setViewHolderData(holder, position);
        viewHolderList.add(holder);

        holder.containerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onListFragmentInteraction(holder.order);
                    AlertDialogView(seleccionarProductos(holder.order));
                }
            }
        });
    }

    private void setViewHolderData(final ViewHolder holder, int position) {
        holder.order = orderList.get(position);
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        String price = decimalFormat.format(orderList.get(position).price);
        String priceText = price + " €";
        //añadir id
        holder.priceTv.setText(priceText);
        holder.tableNumberTv.setText(String.valueOf(orderList.get(position).tableNum));
        holder.dateTv.setText(String.valueOf(orderList.get(position).getDay()));
        holder.horaTv.setText(String.valueOf(orderList.get(position).getHour()));
    }


    @Override
    public int getItemCount() {
        return orderList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View containerView;
        public final TextView tableNumberTv;
        public final TextView priceTv;
        public final TextView dateTv;
        public final TextView horaTv;
        public OrderContainer.Order order;

        public ViewHolder(View view) {
            super(view);
            containerView = view;
            tableNumberTv = (TextView) view.findViewById(R.id.numTableTv);
            dateTv = (TextView) view.findViewById(R.id.textViewDia);
            horaTv = (TextView) view.findViewById(R.id.textViewHora);
            priceTv = (TextView) view.findViewById(R.id.comandaPriceTv);
        }
    }


    private String[] seleccionarProductos(OrderContainer.Order order) {
        DBManager dbManager = new DBManager(context);
        SQLiteDatabase db = dbManager.getWritableDatabase();
        String name = "";
        int quantity = 0;
        int contador = 0;
        Cursor fila = db.rawQuery("SELECT * FROM Products p, Selected s WHERE p.id = s.id_products AND s.id_order = ?", new String[]{String.valueOf(order.getId())});

        String[] ProductosArray = new String[fila.getCount()];

        while (fila.moveToNext()) {
            name = fila.getString(fila.getColumnIndex("name"));
            quantity = fila.getInt(fila.getColumnIndex("quantity"));
            ProductosArray[contador] = quantity + " Unidades de:  " + name;
            contador++;
        }
        return ProductosArray;
    }


    private void AlertDialogView(String[] ProductosArray) {

            if (context != null) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(context);
                mBuilder.setTitle("LISTA DE PRODUCTOS");
                mBuilder.setItems(ProductosArray, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position) {

                    }
                });

                mBuilder.setPositiveButton("Aceptar", null);
                mBuilder.create().show();

            }
        }
    }