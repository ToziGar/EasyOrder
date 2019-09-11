package com.luisgarciamenendez.easyorder.archivos.EditarProductos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luisgarciamenendez.easyorder.archivos.R;
import com.luisgarciamenendez.easyorder.archivos.RecyclerItemClickListener;
import com.luisgarciamenendez.easyorder.archivos.DBWrappers.DishesContainer;
import com.luisgarciamenendez.easyorder.archivos.Utilidades.ItemFragmentUtils;

import java.util.List;


public class EditarProductoItemFragment extends ItemFragmentUtils {

    private OnListFragmentInteractionListener mListener;
    private EditarProductoItemRecyclerViewAdapter editarProductoItemRecyclerViewAdapter;

    public EditarProductoItemFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_editarproductoitem_list, container, false);
        if (view instanceof RecyclerView) {
            super.context = view.getContext();
            super.recyclerView = (RecyclerView) view;
            setRecyclerViewItemTouchListener();
            manageRecyclerViewLayout();
            setRecyclerViewAdapter();
        }
        return view;
    }

    private void setRecyclerViewItemTouchListener() {
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(context, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        EditarProductoItemRecyclerViewAdapter.ViewHolder v = (EditarProductoItemRecyclerViewAdapter.ViewHolder) recyclerView.getChildViewHolder(view);
                        Bundle bundle = makeProductBundle(v.dish);
                        Intent intent = new Intent(getActivity(), EditarProductoActivity.class);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                })
        );
    }

    private Bundle makeProductBundle(DishesContainer.Dish dish){
        Bundle bundle = new Bundle();
        bundle.putInt("mipmap", dish.mipmapId);
        bundle.putString("name", dish.name);
        bundle.putDouble("price", dish.price);
        bundle.putInt("id", dish.id);
        bundle.putBoolean("hasImage", dish.hasImage);
        bundle.putString("image", dish.imgUri);
        return bundle;
    }

    private void setRecyclerViewAdapter() {
        editarProductoItemRecyclerViewAdapter = new EditarProductoItemRecyclerViewAdapter(DishesContainer.getInstance(getActivity().getApplicationContext()), mListener, getActivity().getApplicationContext());
        recyclerView.setAdapter(editarProductoItemRecyclerViewAdapter);
    }

    public void refreshAdapter(List<DishesContainer.Dish> dishes){
        editarProductoItemRecyclerViewAdapter.refreshView(dishes);
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
