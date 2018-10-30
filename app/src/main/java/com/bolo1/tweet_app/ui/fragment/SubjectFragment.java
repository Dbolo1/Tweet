package com.bolo1.tweet_app.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;


import com.bolo1.tweet_app.adapter.MyBaseAdapter;
import com.bolo1.tweet_app.bean.SubjectInfo;
import com.bolo1.tweet_app.holder.BaseHolder;
import com.bolo1.tweet_app.holder.SubjectHolder;
import com.bolo1.tweet_app.http.protocol.SubjectProtocol;
import com.bolo1.tweet_app.ui.uitls.LogUtils;
import com.bolo1.tweet_app.ui.uitls.UIUtils;
import com.bolo1.tweet_app.view.LoadingPage;
import com.bolo1.tweet_app.view.MyListVIew;

import java.util.ArrayList;

/**
 * Created by 菠萝 on 2017/10/16.
 */

public  class SubjectFragment extends BaseListFragment{

    private ArrayList<SubjectInfo.DataBean> data;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateSuccessView() {

        MyListVIew listVIew=new MyListVIew(UIUtils.getContext());
        listVIew.setAdapter(new SubjectAdapter(data));
        return listVIew;
    }

    @Override
    public LoadingPage.ResultState initData() {
        SubjectProtocol  protocol=new SubjectProtocol();
        data = protocol.getData(1);
        LogUtils.d("Subject解析第一页的数据"+data);
        return check(data);
    }

    private class SubjectAdapter  extends MyBaseAdapter<SubjectInfo.DataBean> {

        public SubjectAdapter(ArrayList<SubjectInfo.DataBean> data) {
            super(data);
        }

        @Override
        public BaseHolder<SubjectInfo.DataBean> getHolder(int position) {
            return new SubjectHolder();
        }

        @Override
        public ArrayList<SubjectInfo.DataBean> onLoadMore() {
            SubjectProtocol  protocol= new SubjectProtocol();
            ArrayList<SubjectInfo.DataBean> moreData = protocol.getData(getListSize());

            return moreData;
        }
    }

}
