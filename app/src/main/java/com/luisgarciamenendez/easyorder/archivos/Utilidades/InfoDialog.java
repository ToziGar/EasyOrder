package com.luisgarciamenendez.easyorder.archivos.Utilidades;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.luisgarciamenendez.easyorder.archivos.R;

import java.text.DecimalFormat;


public class InfoDialog extends DialogFragmentUtils {

    private TextView acceptTV, totalTv, textTV, cancelTv;
    private OnInfoDialogDialogResultListener onInfoDialogDialogResultListener;

    public InfoDialog() {
        // Empty constructor required for DialogFragment
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.info_dialog, container);
        initVisualItems(view);
        switch (getDialogType()) {
            case "No products selected":
                configNoProductsSelectedDialog();
                break;
            case "See price":
                configShowPriceDialog();
                break;
            case "Ver el total":
                configSeeTotalDialog();
                break;
            case "Borrar confirmación":
                configDeletingConfirmationDialog();
                break;
            case "Restablecer platos de la mesa":
                configResetDishesTableDialog();
                break;
            case "Restablecer comandas de la mesa":
                configResetOrdersTableDialog();
                break;
        }
        getDialog().setCancelable(true);
        return view;
    }

    private String getDialogType() {
        Bundle b = getArguments();
        return b.getString("Type", null);
    }

    private double getPrice() {
        Bundle b = getArguments();
        return b.getDouble("price", 0);
    }

    private void initVisualItems(View view) {
        acceptTV = (TextView) view.findViewById(R.id.textViewAccept);
        totalTv = (TextView) view.findViewById(R.id.textViewPriceDg);
        textTV = (TextView) view.findViewById(R.id.textViewPriceTx);
        cancelTv = (TextView) view.findViewById(R.id.textViewCancel);
    }

    private void configNoProductsSelectedDialog() {
        textTV.setText("Añadir cualquier producto al pedido.");
        textTV.setTextColor(getResources().getColor(R.color.primary_text));
        totalTv.setVisibility(View.GONE);
        cancelTv.setVisibility(View.GONE);
        acceptTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    private void configSeeTotalDialog() {
        textTV.setText("Las ganancias ascienden a");
        configShowPriceDialog();
    }

    private void configShowPriceDialog() {
        String roundedPrice = getRoundedPrice(getPrice());
        cancelTv.setVisibility(View.GONE);
        textTV.setTextColor(Color.argb(ConstantValues.alpha, 0, 0, 0));
        totalTv.setText(String.valueOf(roundedPrice + " €"));
        acceptTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    private String getRoundedPrice(double price) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return decimalFormat.format(price);
    }

    private void configDeletingConfirmationDialog() {
        textTV.setText("¿Estás seguro de querer borrar el producto?");
        configAcceptCancelDialog();
    }

    private void configResetDishesTableDialog() {
        textTV.setText("¿Estás seguro de querer borrar todos los productos?");
        configAcceptCancelDialog();
    }

    private void configResetOrdersTableDialog() {
        textTV.setText("¿Estás seguro de querer borrar todos los pedidos?");
        configAcceptCancelDialog();
    }

    private void configAcceptCancelDialog() {
        textTV.setTextColor(Color.argb(ConstantValues.alpha, 0, 0, 0));
        totalTv.setVisibility(View.GONE);
        acceptTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onInfoDialogDialogResultListener.onPositiveResult();
                dismiss();
            }
        });
        setCancelTvClickListener();
    }

    private void setCancelTvClickListener() {
        cancelTv.setOnClickListener(super.getDismissClickLitener());
    }

    public interface OnInfoDialogDialogResultListener {
        public abstract void onPositiveResult();
        public abstract void onNegativeResult();
    }

    public void setOnInfoDialogDialogResultListener(OnInfoDialogDialogResultListener onInfoDialogDialogResultListener) {
        this.onInfoDialogDialogResultListener = onInfoDialogDialogResultListener;
    }
}
