package com.bolo1.tweet_app.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.bolo1.tweet_app.R;
import com.bolo1.tweet_app.adapter.BaseViewPagerAdapter;
import com.bolo1.tweet_app.ui.uitls.PagerTab;

import org.w3c.dom.Text;

import butterknife.InjectView;

/**
 * Created by 菠萝 on 2018/4/20.
 */

public class NewsFragment extends BaseViewPagerFragment{

    @Override
    public void addPagerToAdapter(BaseViewPagerAdapter adapter) {
        String[] title_arrys = getResources().getStringArray(R.array.news_title);
        adapter.addPager(title_arrys[0],new TweetFragment());
        adapter.addPager(title_arrys[1],new CommentFragment());
        adapter.addPager(title_arrys[2],new TestFragment());
        Log.d("newsFragment","执行到了这里");
    }




}
