package com.bolo1.tweet_app.ui.activites;

import com.bolo1.tweet_app.R;
import com.bolo1.tweet_app.bean.ShortVideo;
import com.bolo1.tweet_app.ui.fragment.CommentFragment;
import com.bolo1.tweet_app.ui.fragment.LoadTestMoreFragment;
import com.bolo1.tweet_app.ui.fragment.MeFragment;
import com.bolo1.tweet_app.ui.fragment.NewsFragment;
import com.bolo1.tweet_app.ui.fragment.ShortVideoFragment;
import com.bolo1.tweet_app.ui.fragment.TestFragment;
import com.bolo1.tweet_app.ui.fragment.TweetFragment;

/**
 * Created by 菠萝 on 2018/4/20.
 */

public enum MainTab {
    //写三个枚举
    NEWS(0, R.string.news_title,R.drawable.tab_icon_news,NewsFragment.class),
    TWEET(1, R.string.home_title,R.drawable.tab_icon_tweet,LoadTestMoreFragment.class),
    ME(2, R.string.me_title,R.drawable.tab_icon_me,MeFragment.class);
    private int idx;
    private Class<?> clz;
    private int ResName;
    private int ResIcon;

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }


    public Class<?> getClz() {
        return clz;
    }

    public void setClass(java.lang.Class<?> aClass) {
        clz = aClass;
    }

    public int getResName() {
        return ResName;
    }

    public void setResName(int resName) {
        ResName = resName;
    }

    public int getResIcon() {
        return ResIcon;
    }

    public void setResIcon(int resIcon) {
        ResIcon = resIcon;
    }

    MainTab(int idx, int ResName, int ResIcon,Class<?> clz) {
        this.idx = idx;
        this.clz = clz;
        this.ResIcon = ResIcon;
        this.ResName = ResName;
    }

}
