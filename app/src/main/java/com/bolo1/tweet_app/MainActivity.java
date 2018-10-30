package com.bolo1.tweet_app;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;

import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.content.ContextCompat;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.bolo1.tweet_app.ui.activites.BaseActivity;
import com.bolo1.tweet_app.ui.activites.MainTab;
import com.bolo1.tweet_app.ui.fragment.TestFragment;
import com.bolo1.tweet_app.ui.uitls.UIUtils;


import butterknife.ButterKnife;
import butterknife.InjectView;

import static com.bolo1.tweet_app.ui.uitls.UIUtils.getString;

public class MainActivity extends BaseActivity implements View.OnClickListener, View.OnTouchListener {
//    @InjectView(R.id.vp_main)
//    ViewPager vp_main;

    @InjectView(R.id.fl_synthesize)
    public FrameLayout fl_synthesize;
    @InjectView(R.id.tabs)
    public FragmentTabHost tabs;
    @InjectView(R.id.ll_empty_layout)
    public LinearLayout ll_empty_layout;
//    @InjectView(R.id.tb_home)
   public android.support.v7.widget.Toolbar tb_home;

    protected Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

   protected void onRequestPer(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!=
                PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        }
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onRequestPer();
    }



    public void initView(View rootView) {
        tb_home =  this.findViewById(R.id.tb_home);
        ButterKnife.inject(this);
       // initToolbar();

        tabs.setup(this, getSupportFragmentManager(), R.id.fl_synthesize);
        MainTab[] values = MainTab.values();
        for (int i = 0; i < MainTab.values().length; i++) {
            MainTab tab = values[i];
            //tab标题
            String[] stringArray = getResources().getStringArray(R.array.title_tab);
            TabHost.TabSpec tabSpec = tabs.newTabSpec(getString(tab.getResName()));

            //自定义view

            View view = View.inflate(this, R.layout.tab_layout, null);
            TextView tab_title = (TextView) view.findViewById(R.id.tab_title);
            tab_title.setText(getString(tab.getResName()));
//            getResources().getColor(Color.R.drawable.tabhost_title)
//            tab_title.setTextColor(this.getResources().getColor(R.color.colorPrimary));
            Drawable drawable = this.getResources().getDrawable(tab.getResIcon());
            tab_title.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
//            if(i==2){
//                tab_title.setVisibility(View.INVISIBLE);
//            }
            tabSpec.setContent(new TabHost.TabContentFactory() {

                @Override
                public View createTabContent(String tag) {
                    return new View(MainActivity.this);
                }
            });
            tabSpec.setIndicator(view);
            Bundle bundle2 = new Bundle();
            bundle2.putString("text", "content: " + getString(tab.getResName()));
            // 2. 把新的选项卡添加到TabHost中
            tabs.addTab(tabSpec, tab.getClz(), bundle2);
            tabs.getTabWidget().getChildAt(i).setOnTouchListener(this);
        }
        tabs.setCurrentTab(0);
    }

//    //考虑封装toolbar
//    @SuppressWarnings("deprecation")
//    private void initToolbar() {
//        if (tb_home != null) {
//            setSupportActionBar(tb_home);
//        }
//
//        // tb_home.setTitle(R.string.app_name);
//        // tb_home.setTitleTextColor(getResources().getColor(R.color.tb_title));
//        //    tb_home.setNavigationIcon(R.mipmap.ic_launcher);
//        tb_home.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                for (Activity activity : activities) {
//                    if (activity instanceof MainActivity) {
//                        return;
//                    } else {
//                        finish();
//                    }
//                }
//            }
//        });
//
//
////        tb_home.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
////            @Override
////            public boolean onMenuItemClick(MenuItem item) {
////                //预留
////                switch (item.getItemId()){
////                    case R.id.menu_search:
////                        Toast.makeText(UIUtils.getContext(),"搜索",Toast.LENGTH_SHORT).show();
////                        break;
////                    case R.id.menu_item2:
////                        Toast.makeText(UIUtils.getContext(),"menu_item2",Toast.LENGTH_SHORT).show();
////                        break;
////                }
////                return true;
////            }
////        });
//
//
//    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.tb_home_menu,menu);
//        return super.onCreateOptionsMenu(menu);
//    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public void initData() {

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}
