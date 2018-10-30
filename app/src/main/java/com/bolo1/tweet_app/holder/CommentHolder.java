package com.bolo1.tweet_app.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bolo1.tweet_app.R;
import com.bolo1.tweet_app.media.AndroidMediaController;
import com.bolo1.tweet_app.media.IjkVideoView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by 菠萝 on 2018/6/28.
 */

public class CommentHolder extends RecyclerView.ViewHolder {
    @InjectView(R.id.tv_user_name)
    public TextView tv_user_name;
    @InjectView(R.id.iv_user_icon)
    public ImageView iv_user_icon;
    @InjectView(R.id.iv_comments_share)
    public ImageView iv_comments_share;
    @InjectView(R.id.tv_comment_like)
    public  TextView tv_comment_like;
    @InjectView(R.id.tv_comment_comments)
    public  TextView tv_comment_comments;
//    @InjectView(R.id.tv_video_date)
//    public TextView tv_video_date;
//    @InjectView(R.id.iv_video_play)
//    public  ImageView iv_video_play;
//    @InjectView(R.id.iv_video_preview)
//    public  ImageView iv_video_preview;
//    public  IjkVideoView vv_comment;
//    @InjectView(R.id.rl_play_col)
//    public RelativeLayout rl_play_col;


    public CommentHolder(View view) {
        super(view);
      //  vv_comment = itemView.findViewById(R.id.vv_comment);
        ButterKnife.inject(this,itemView);
    }
}
