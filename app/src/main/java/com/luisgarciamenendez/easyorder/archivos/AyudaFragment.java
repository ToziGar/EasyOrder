package com.luisgarciamenendez.easyorder.archivos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.luisgarciamenendez.easyorder.archivos.Utilidades.ConstantValues;

public class AyudaFragment extends Fragment {

    ImageView nuevoPedidoIcon;
    ImageView editarProductosIcon;
    ImageView listaPedidosicon;
    ImageView productosStockIcon;
    ImageView ajustesIcon;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ayuda, container, false);
        initVisuals(view);
        setIconAlphas();
        return view;
    }

    private void initVisuals(View view) {
        nuevoPedidoIcon = (ImageView) view.findViewById(R.id.iconNuevoPedido);
        editarProductosIcon = (ImageView) view.findViewById(R.id.iconEditarProductos);
        listaPedidosicon = (ImageView) view.findViewById(R.id.iconListaPedidos);
        productosStockIcon = (ImageView) view.findViewById(R.id.iconStockProductos);
        ajustesIcon = (ImageView) view.findViewById(R.id.iconConfiguracion);
    }

    private void setIconAlphas() {
        nuevoPedidoIcon.setAlpha(ConstantValues.alpha);
        editarProductosIcon.setAlpha(ConstantValues.alpha);
        listaPedidosicon.setAlpha(ConstantValues.alpha);
        productosStockIcon.setAlpha(ConstantValues.alpha);
        ajustesIcon.setAlpha(ConstantValues.alpha);
    }

}
