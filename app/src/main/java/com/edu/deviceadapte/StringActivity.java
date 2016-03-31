package com.edu.deviceadapte;

import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class StringActivity extends AppCompatActivity {

    private TextView screen_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string);

        //获取屏幕的尺寸信息
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
//        getWindowManager().getDefaultDisplay();
        int widthPixels = displayMetrics.widthPixels;
        int heightPixels = displayMetrics.heightPixels;

        //对应密度的缩放比率，（dpi/160）
        //相对于mdpi（160）而言的缩放比率
        float scaledDensity = displayMetrics.scaledDensity;

        float density = displayMetrics.density;

        float wdp = widthPixels / density;
        float hdp = heightPixels / density;
        screen_info = (TextView) findViewById(R.id.screen_info);
        if (screen_info != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("屏幕宽度:")
                    .append(widthPixels + "\n")
                    .append("屏幕高度:")
                    .append(heightPixels + "\n")
                    .append("屏幕密度:")
                    .append(displayMetrics.densityDpi + "\n")
                    .append("缩放比率:")
                    .append(scaledDensity + "\n")
                    .append("hdp:")
                    .append(hdp + "\n")
                    .append("wdp:")
                    .append(wdp + "\n")
            ;
            screen_info.setText(sb.toString());
        }

        //Android操作系统版本的适配
        //通过Build就可以获取当前操作系统的版本号
        //API级别
        //Android程序运行时，只要不调用不存在的方法，就不会出错，
        //可以正常的的编译成功
        if (Build.VERSION.SDK_INT>=11){
            screen_info.setX(133);
        }else{
            ViewCompat.setX(screen_info,133);
        }
    }
}
