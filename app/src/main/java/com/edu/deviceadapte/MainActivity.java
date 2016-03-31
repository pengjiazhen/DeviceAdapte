package com.edu.deviceadapte;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.edu.deviceadapte.fragment.MenuFragment;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //当横竖屏切换，当前activity会销毁，
        //会重新创建Activity的实例，在一次调用onCreate
        //setContentView就会重新加载布局
        //android系统就会根据当前手机的状态和参数
        //定位到程序特定的目录，例如：layout-land
        //中同名的xml文件，来加载。
        setContentView(R.layout.activity_main);
        //如果onCreate的参数有值
        // 代表当前的activity被系统重新创建的，
        // 会把activity内部fragmentManager管理的fragment，自动重新创建一次
        //因此通常不需要再创建fragment了
        FragmentManager manager = getSupportFragmentManager();
       // fragment = new MenuFragment();
        if (savedInstanceState == null) {
            Log.d(TAG, "onCreate: 第一次创建");

            FragmentTransaction transaction = manager.beginTransaction();
           Fragment fragment = new MenuFragment();
            //支持横竖屏切换的时候，fragment对象需要从fragmentManager中去查找fragment对象
            transaction.replace(R.id.menu_list, fragment,"fragment");

            transaction.commit();
//            fragment = new MenuFragment();
        }else {
            Log.d(TAG, "onCreate: 横竖屏切换");
           // fragment = manager.findFragmentByTag("fragment");
        }
        //需要获取指定的fragment
        Fragment fragment = manager.findFragmentByTag("fragment");


        //可以在特定的布局中加入一些id，查找id就就可以判断加载的是哪一个xml文件
        View view =  findViewById(R.id.detail_container);

        if (view != null) {
            // TODO: 2016/3/30 处理横屏的情况

        }else {
            // TODO: 2016/3/30 处理竖屏的情况
        }
    }
}
