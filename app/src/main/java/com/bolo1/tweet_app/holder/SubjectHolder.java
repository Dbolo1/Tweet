package com.bolo1.tweet_app.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.bolo1.tweet_app.R;
import com.bolo1.tweet_app.bean.SubjectInfo;
import com.bolo1.tweet_app.ui.uitls.UIUtils;
import com.lidroid.xutils.BitmapUtils;


/**
 * Created by 菠萝 on 2017/10/27.
 */

public class SubjectHolder extends BaseHolder<SubjectInfo.DataBean> {

    private TextView tv_subject_des;
    private ImageView iv_subject_image;
    private BitmapUtils mBitmapUtils;

    @Override
    public View initView() {
         View view =UIUtils.getinflate(R.layout.subject_list_item);
        tv_subject_des = (TextView) view.findViewById(R.id.tv_subject_des);
        iv_subject_image = (ImageView) view.findViewById(R.id.iv_subject_image);
        mBitmapUtils = new BitmapUtils(UIUtils.getContext());
        return view;
    }

    @Override
    public void refreshView(SubjectInfo.DataBean data) {
        tv_subject_des.setText(data.getAbs());
        mBitmapUtils.display(iv_subject_image, data.getImage_urlX());
    }
}
