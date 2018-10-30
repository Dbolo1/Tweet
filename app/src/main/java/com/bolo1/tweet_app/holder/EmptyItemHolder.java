package com.bolo1.tweet_app.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bolo1.tweet_app.R;

/**
 * Created by 菠萝 on 2018/6/28.
 */

public class EmptyItemHolder  extends RecyclerView.ViewHolder{

    public  ImageView iv_load_anim;

    public EmptyItemHolder(View itemView) {
        super(itemView);
        iv_load_anim = itemView.findViewById(R.id.iv_load_anim);
    }
}
