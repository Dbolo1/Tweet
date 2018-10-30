package com.bolo1.tweet_app.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bolo1.tweet_app.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by 菠萝 on 2018/6/28.
 */

public class TweetHolder extends RecyclerView.ViewHolder {
    //    @InjectView(R.id.iv_tweet_picture2)
//    public ImageView iv_tweet_picture2;
//    @InjectView(R.id.iv_tweet_picture3)
//    public ImageView iv_tweet_picture3;

//    @InjectView(R.id.tv_tweet_des)
//    public TextView tv_tweet_des;
//    @InjectView(R.id.tv_tweet_title)
//    public  TextView tv_tweet_title;
//    @InjectView(R.id.iv_tweet_picture1)
//    public ImageView iv_tweet_picture1;
//    @InjectView(R.id.tv_tweet_author)
//    public TextView tv_tweet_author;
//    @InjectView(R.id.tv_tweet_time)
//    public  TextView tv_tweet_time;
//    @InjectView(R.id.ll_tweet_des)
//    public  LinearLayout ll_tweet_des;
//    @InjectView(R.id.ll_tweet_picture)
//    public LinearLayout ll_tweet_picture;
//    @InjectView(R.id.tv_tweet_comment_number)
//    public TextView tv_tweet_comment_number;

    ////换一个layout
    @InjectView(R.id.ll_news_item_1)
    public LinearLayout ll_news_item_1;
    @InjectView(R.id.tv_news_item_1_title_1)
    public TextView tv_news_item_1_title_1;
    @InjectView(R.id.tv_news_item_1_date_1)
    public TextView tv_news_item_1_date_1;
    @InjectView(R.id.tv_news_item_1_comments_1)
    public TextView tv_news_item_1_comments_1;
    @InjectView(R.id.iv_news_item_image_1)
    public ImageView iv_news_item_image_1;
    ///----item1-
    @InjectView(R.id.ll_news_item_2)
    public LinearLayout ll_news_item_2;
    @InjectView(R.id.tv_news_item_2_title_1)
    public TextView tv_news_item_2_title_1;
    @InjectView(R.id.iv_news_item_2_image_1)
    public ImageView iv_news_item_2_image_1;
    @InjectView(R.id.iv_news_item_2_image_2)
    public ImageView iv_news_item_2_image_2;
    @InjectView(R.id.iv_news_item_2_image_3)
    public ImageView iv_news_item_2_image_3;
    @InjectView(R.id.tv_news_item_3_title_1)
    public TextView tv_news_item_3_title_1;
    @InjectView(R.id.ll_news_item_3)
    public LinearLayout ll_news_item_3;

    @InjectView(R.id.ll_news_item_0)
    public LinearLayout ll_news_item_0;
    @InjectView(R.id.tv_news_item_0_title_0)
    public TextView tv_news_item_0_title_0;
    @InjectView(R.id.tv_news_item_0_des)
    public TextView tv_news_item_0_des;
    @InjectView(R.id.tv_news_item_0_date_0)
    public TextView tv_news_item_0_date_0;
    @InjectView(R.id.tv_news_item_0_comments_0)
    public TextView tv_news_item_0_comments_0;


    @InjectView(R.id.tv_news_item_1_des)
    public TextView tv_news_item_1_des;
    @InjectView(R.id.ll_news_item_1_image)
    public LinearLayout ll_news_item_1_image;


    public TweetHolder(View view) {
        super(view);
        ButterKnife.inject(this, view);
    }
}
