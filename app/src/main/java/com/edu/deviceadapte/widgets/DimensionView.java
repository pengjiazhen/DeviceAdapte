package com.edu.deviceadapte.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Description： TODO<br/>
 * Copyright (c) , 2016, 彭家珍 <br/>
 * This program is protected by copyright laws. <br/>
 * Program Name:DeviceAdapte <br/>
 * Date: 2016/3/30
 *
 * @author 彭家珍
 * @version : 1.0
 */
public class DimensionView extends View {
    private static final String TAG = DimensionView.class.getSimpleName();

    public DimensionView(Context context) {
        this(context, null);
    }

    public DimensionView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DimensionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        Log.d(TAG, "width:"+widthSize+"    height:"+heightSize);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
