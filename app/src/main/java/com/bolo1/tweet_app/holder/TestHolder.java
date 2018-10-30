package com.bolo1.tweet_app.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bolo1.tweet_app.R;
import com.bolo1.tweet_app.adapter.BaseRecycleAdapter;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by 菠萝 on 2018/6/28.
 */

public class TestHolder extends RecyclerView.ViewHolder {
  // public  TextView tv_test_load;
    @InjectView(R.id.tv_joke_des)
   public  TextView tv_joke_des;
    @InjectView(R.id.tv_des_comments)
    public  TextView tv_des_comments;
    @InjectView(R.id.tv_des_dislike)
    public TextView tv_des_dislike;
    @InjectView(R.id.tv_des_like)
    public  TextView tv_des_like;
    @InjectView(R.id.iv_user_icon)
    public  ImageView iv_user_icon;
    @InjectView(R.id.tv_user_name)
    public  TextView tv_user_name;

    public TestHolder(View itemView) {
        super(itemView);
        ButterKnife.inject(this,itemView);
    }
}
