package com.logotet.foolaround.myui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.logotet.foolaround.R;

/**
 * Created by boban on 11/29/15.
 */
public class LottoCompound extends RelativeLayout {
    private TextView tvLottoSize;
    private TextView tvMinusOne;
    private TextView tvPlusOne;


    public LottoCompound(Context context) {
        super(context);
        initControl(context);
    }

    public LottoCompound(Context context, AttributeSet attrs) {
        super(context, attrs);
        initControl(context);
    }

    public LottoCompound(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initControl(context);
    }

    private void initControl(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.lottocompound, this);
        tvLottoSize = (TextView) findViewById(R.id.tvLottoSize);
        tvMinusOne = (TextView) findViewById(R.id.tvMinusOne);
        tvPlusOne = (TextView) findViewById(R.id.tvPlusOne);
        update();
    }
    private void update() {
    }

}
