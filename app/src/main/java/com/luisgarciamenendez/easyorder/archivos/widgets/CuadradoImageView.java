package com.luisgarciamenendez.easyorder.archivos.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;


public class CuadradoImageView extends ImageView {

    public CuadradoImageView(Context context) {
        super(context);
    }

    public CuadradoImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CuadradoImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = getMeasuredWidth();
        setMeasuredDimension(width, width);
    }
}
