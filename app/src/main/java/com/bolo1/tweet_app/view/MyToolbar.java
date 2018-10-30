package com.bolo1.tweet_app.view;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;

/**
 * Created by 菠萝 on 2018/5/3.
 */

public abstract class MyToolbar extends Toolbar {
    private Context context;

    public MyToolbar(Context context) {
        this(context,null);

    }


    private void init(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this.context=context;
       setToolbarTitle(context);

    }

    private void setToolbarTitle(Context context) {
        if(setCustomTitle()==null&&setCustomTitle().equals("")){
            this.setTitle("Tweet");
        }else{
            this.setTitle(setCustomTitle());
        }
       // this.setMenu();

    }

    public MyToolbar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);

    }

    public MyToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    public abstract  String  setCustomTitle();


}
