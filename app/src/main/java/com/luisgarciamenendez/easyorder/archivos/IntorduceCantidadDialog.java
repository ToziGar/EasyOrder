package com.luisgarciamenendez.easyorder.archivos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

public class IntorduceCantidadDialog extends DialogFragment {

    TextView acceptTV, cancelTv;
    EditText cantidadEt;
    OnDialogResultListener onDialogResultListener;

    public IntorduceCantidadDialog() {
        // Empty constructor required for DialogFragment
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.insertar_cantidad_dialog, container);
        initVisuals(view);
        configCantidadEt();
        setCancelClickListener();
        setAcceptClickListener();
        getDialog().setCancelable(true);
        return view;
    }

    private void initVisuals(View view) {
        cantidadEt = (EditText) view.findViewById(R.id.editTextCantidad);
        acceptTV = (TextView) view.findViewById(R.id.textViewAccept);
        cancelTv = (TextView) view.findViewById(R.id.textViewCancel);
    }

    private void configCantidadEt() {
        cantidadEt.requestFocus();
        getDialog().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    private void setCancelClickListener() {
        cancelTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDialogResultListener.onNegativeResult();
                dismiss();
            }
        });
    }

    private void setAcceptClickListener() {
        acceptTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = cantidadEt.getText().toString();
                if(!string.equals("")){
                    int i = Integer.parseInt(cantidadEt.getText().toString());
                    if(i>-1){
                        onDialogResultListener.onPositiveResult(i);
                    }
                }
                dismiss();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    public interface OnDialogResultListener {
        public abstract void onPositiveResult(int value);
        public abstract void onNegativeResult();
    }

    public void setOnDialogResultListener(OnDialogResultListener listener) {
        this.onDialogResultListener = listener;
    }

}