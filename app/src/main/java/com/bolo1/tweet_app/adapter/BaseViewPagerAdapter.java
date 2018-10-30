package com.bolo1.tweet_app.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by 菠萝 on 2018/3/8.
 */

public class BaseViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<String> titles;
    private ArrayList<Fragment> fragments;
    private Bundle bundle;


    public BaseViewPagerAdapter(FragmentManager fm) {
        super(fm);
        titles= new ArrayList<>();
        fragments = new ArrayList<>();
//         bundle = new Bundle();
    }

    public void addPager(String title, Fragment fragment){
//        bundle.putString("key",string);
        titles.add(title);
        fragments.add(fragment);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
