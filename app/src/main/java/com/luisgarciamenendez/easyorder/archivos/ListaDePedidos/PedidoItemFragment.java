package com.luisgarciamenendez.easyorder.archivos.ListaDePedidos;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.luisgarciamenendez.easyorder.archivos.Utilidades.InfoDialog;
import com.luisgarciamenendez.easyorder.archivos.R;
import com.luisgarciamenendez.easyorder.archivos.DBWrappers.OrderContainer;
import com.luisgarciamenendez.easyorder.archivos.Utilidades.ItemFragmentUtils;




public class PedidoItemFragment extends ItemFragmentUtils {

    private OnListFragmentInteractionListener orderItemfragmentInteractionListener;
    private PedidoItemRecyclerViewAdapter pedidoItemRecyclerViewAdapter;


    public PedidoItemFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pedidositem_list, container, false);
        if (view instanceof RecyclerView) {
            super.context = view.getContext();
            super.recyclerView = (RecyclerView) view;
            super.manageRecyclerViewLayout();
            setRecyclerViewAdapter();
        }
        return view;
    }

    private void setRecyclerViewAdapter() {
        OrderContainer orderContainer = OrderContainer.getInstance(getActivity().getApplicationContext());
        pedidoItemRecyclerViewAdapter = new PedidoItemRecyclerViewAdapter(orderContainer.getOrderList(), orderItemfragmentInteractionListener);
        recyclerView.setAdapter(pedidoItemRecyclerViewAdapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            orderItemfragmentInteractionListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        orderItemfragmentInteractionListener = null;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.listar_pedidos_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_info){
            showInfoDialog();
        }
        return super.onOptionsItemSelected(item);
    }

    private void showInfoDialog() {
        InfoDialog infoDialog = new InfoDialog();
        infoDialog.setStyle(DialogFragment.STYLE_NO_TITLE, 0);
        Bundle bundle = makeInfoDialogBundle();
        infoDialog.setArguments(bundle);
        android.support.v4.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        infoDialog.show(fragmentManager, "tag");
    }

    private Bundle makeInfoDialogBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("Type", "Ver el total");
        bundle.putDouble("price", pedidoItemRecyclerViewAdapter.getTotalPrice());
        return bundle;
    }

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(OrderContainer.Order order);
    }
}
