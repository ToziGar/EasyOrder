package com.luisgarciamenendez.easyorder.archivos.StockProductos;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luisgarciamenendez.easyorder.archivos.R;
import com.luisgarciamenendez.easyorder.archivos.RecyclerItemClickListener;
import com.luisgarciamenendez.easyorder.archivos.DBManager.DBManager;
import com.luisgarciamenendez.easyorder.archivos.DBWrappers.DishesContainer;
import com.luisgarciamenendez.easyorder.archivos.Utilidades.ItemFragmentUtils;


public class ProductoStockItemFragment extends ItemFragmentUtils {

    private OnListFragmentInteractionListener mListener;
//    private DishesContainer dishesContainer;
    private ProductoStockItemRecyclerViewAdapter productoStockItemRecyclerViewAdapter;

    public ProductoStockItemFragment() {
        //Required empty constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        dishesContainer = DishesContainer.getInstance(getActivity().getApplicationContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_itemstock_list, container, false);
        if (view instanceof RecyclerView) {
            super.context = view.getContext();
            super.recyclerView = (RecyclerView) view;
            setRecyclerViewClickListener();
            super.manageRecyclerViewLayout();
            setRecyclerViewAdapter();
        }
        return view;
    }

    private void setRecyclerViewAdapter() {
        productoStockItemRecyclerViewAdapter = new ProductoStockItemRecyclerViewAdapter(DishesContainer.getInstance(getActivity().getApplicationContext()), mListener, getContext());
        recyclerView.setAdapter(productoStockItemRecyclerViewAdapter);
    }

    private void setRecyclerViewClickListener() {
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(context, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(final View view, int position) {
                        showStockDialog(view);
                    }
                })
        );
    }

    private void showStockDialog(View view) {
        EditarStockDialog editarStockDialog = new EditarStockDialog();
        android.support.v4.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        editarStockDialog.setStyle(DialogFragment.STYLE_NO_TITLE, 0);
        setStockDialogResultListener(editarStockDialog, view);
        editarStockDialog.show(fragmentManager, "tag");
    }

    private void setStockDialogResultListener(EditarStockDialog editarStockDialog, final View view) {
        editarStockDialog.setOnStockDialogResultListener(new EditarStockDialog.OnStockDialogResultListener() {
            @Override
            public void onPositiveResult(Bundle bundle) {
                manageStockDialogPositiveResult(view, bundle);
            }
            @Override
            public void onNegativeResult() {
            }
        });
    }

    private void manageStockDialogPositiveResult(View view, Bundle bundle) {
        ProductoStockItemRecyclerViewAdapter.ViewHolder v = (ProductoStockItemRecyclerViewAdapter.ViewHolder) recyclerView.getChildViewHolder(view);
        String opcio = bundle.getString("opcio", "");
        if (opcio.equals("zero")){
            v.decreaseQuantityToZero();
        } else if (opcio.equals("incrementar")){
            v.increaseQuantityByX(bundle.getInt("quantitat"));
        } else if (opcio.equals("decrementar")){
            v.decreaseQuantityByX(bundle.getInt("quantitat"));
        }
        DBManager.getInstance(getActivity().getApplicationContext()).updateDish(v.dish.id, v.stock);
        DishesContainer.refresh(getActivity().getApplicationContext());
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

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(DishesContainer.Dish dish);
    }
}
