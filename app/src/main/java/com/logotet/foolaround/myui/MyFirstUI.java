package com.logotet.foolaround.myui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import com.logotet.foolaround.R;

/**
 * Created by boban on 11/29/15.
 */
public class MyFirstUI extends View {
    private int min;
    private int max;
    private int value;

    private int lineColor;
    private int thick; // debljina linije



    public MyFirstUI(Context context) {
        super(context);
    }

    public MyFirstUI(Context context, AttributeSet attrs) {
        super(context, attrs);
        final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MyFirstUI);
//        final int vertical = a.getInt(R.styleable.MyFirstUI_orientation, 0);
        final int maxa = a.getInt(R.styleable.MyFirstUI_max, 20);
        final int mina = a.getInt(R.styleable.MyFirstUI_min, 99);
        final int vala = a.getInt(R.styleable.MyFirstUI_value,49);
        final int cola = a.getColor(R.styleable.MyFirstUI_linecolor, Color.RED);

        setMax(maxa);
        setMin(mina);
        setValue(vala);
        setLineColor(cola);
    }

    public MyFirstUI(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getMeasuredWidth();
        int height = getMeasuredHeight();

        Paint p = new Paint();
        p.setColor(lineColor);

        canvas.drawRect(0, 0, 2*width, 14, p);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setLineColor(int color) {
        this.lineColor = color;
    }

    public int getValue() {
        return value;
    }
}
