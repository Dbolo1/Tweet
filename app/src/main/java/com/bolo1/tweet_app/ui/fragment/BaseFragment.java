package com.bolo1.tweet_app.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bolo1.tweet_app.MainActivity;
import com.bolo1.tweet_app.R;

/**
 * Created by 菠萝 on 2018/4/20.
 */

public  abstract class BaseFragment extends Fragment{

    private Bundle arguments;
    private String title_test;
    private MainActivity activity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      //  View inflate = LayoutInflater.from(getContext()).inflate(R.layout.test_layout, null);
       // View viewById = inflate.findViewById(R.id.tv_test);
        return getLoadView(inflater,container,savedInstanceState);
    }

    public abstract View getLoadView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
