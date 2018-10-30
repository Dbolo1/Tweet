package com.bolo1.tweet_app.ui.activites;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;

/**
 * Created by 菠萝 on 2018/4/20.
 */

public abstract  class BaseActivity extends AppCompatActivity {

    protected  ArrayList<Activity> activities=new ArrayList<Activity>();
    private BaseActivity mActivity;
    private View rootView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //不需要透明化导航栏
          //  window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        super.onCreate(savedInstanceState);
        mActivity = this;
        if (activities != null && !activities.contains(mActivity)) {
            activities.add(mActivity);
        }
        setContentView(getLayoutID());
        initView(getRootView());
        initData();
    }

    protected abstract int getLayoutID();

    /// 记录activity
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(activities!=null){
            activities.remove(mActivity);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
    public abstract  void initView(View rootView);
    public abstract  void initData();


    public View getRootView() {
        if(getLayoutID()==-1){
            throw  new IllegalArgumentException("布局不能为空");
        }else {
            rootView = LayoutInflater.from(mActivity).inflate(getLayoutID(), null);
        }
        return rootView;
    }
}
