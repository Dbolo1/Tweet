package com.bolo1.tweet_app.holder;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bolo1.tweet_app.R;

/**
 * Created by 菠萝 on 2018/6/28.
 */

public class FootHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
    public  ProgressBar pb_load_more;
    public TextView tv_load_more;
    public FootHolder(View itemView) {
        super(itemView);
         pb_load_more = itemView.findViewById(R.id.pb_load_more);
         tv_load_more = itemView.findViewById(R.id.tv_load_more);
    }
}
