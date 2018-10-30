package com.bolo1.tweet_app.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bolo1.tweet_app.R;
import com.bolo1.tweet_app.media.IjkVideoView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by 菠萝 on 2018/7/18.
 */

public class HomeHolder extends RecyclerView.ViewHolder {
   @InjectView(R.id.tv_home_recommend)
    public TextView tv_home_recommend;
    @InjectView(R.id.tv_home_round)
    public TextView tv_home_round;
    @InjectView(R.id.iv_search_home)
    public ImageView iv_search_home;
    @InjectView(R.id.iv_home_author)
    public ImageView iv_home_author;
    @InjectView(R.id.iv_home_add)
    public ImageView iv_home_add;
    @InjectView(R.id.tv_home_like)
    public TextView tv_home_like;
    @InjectView(R.id.tv_home_comment)
    public TextView tv_home_comment;
    @InjectView(R.id.tv_home_share)
    public TextView tv_home_share;
    @InjectView(R.id.tv_home_author_name)
    public TextView tv_home_author_name;
    @InjectView(R.id.tv_home_title)
    public TextView tv_home_title;
    @InjectView(R.id.tv_home_music_name)
    public TextView tv_home_music_name;
    @InjectView(R.id.iv_home_music)
    public ImageView iv_home_music;
    @InjectView(R.id.ll_home_main)
    public LinearLayout ll_home_main;
  @InjectView(R.id.ijk_home)
  public IjkVideoView ijk_home;
    public HomeHolder(View itemView) {
        super(itemView);
        ButterKnife.inject(this,itemView);
    }
}
