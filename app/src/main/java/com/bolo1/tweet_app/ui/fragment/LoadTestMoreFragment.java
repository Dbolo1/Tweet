package com.bolo1.tweet_app.ui.fragment;

import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bolo1.tweet_app.R;
import com.bolo1.tweet_app.adapter.BaseRecycleAdapter;
import com.bolo1.tweet_app.holder.TestHolder;
import com.bolo1.tweet_app.ui.recycle.BaseRecycleFragment;

import java.util.ArrayList;

/**
 * Created by 菠萝 on 2018/6/27.
 */

public class LoadTestMoreFragment extends BaseRecycleFragment {

    private LoadTestMoreAdapter loadTestMoreAdapter;

    @Override
    protected void upDataOfView(Message msg) {

    }

    @Override
    public void sendRequestData() {
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            strings.add("这是一段测试文本=====" + i);
        }
        strings.add("文本的结束-------------------------------");
        Log.d("tag", "sendRequest走了几次" + "输出的结果=====" + strings.toString());
        loadTestMoreAdapter.addData(strings);
    }

    @Override
    public BaseRecycleAdapter getChildAdapter() {
        if (loadTestMoreAdapter == null) {
            loadTestMoreAdapter = new LoadTestMoreAdapter();
            OnLoadMoreListener onLoadMoreListener = new OnLoadMoreListener() {
                @Override
                public void onLoadMore() {
                    // sendRequestData();
                    ArrayList<String> strings = new ArrayList<>();
                    for (int i = 0; i < 7; i++) {
                        strings.add("这是加载后的数据=====" + i);
                    }
                    strings.add("文本的结束--------------加载后的结束点-----------------");
                    loadTestMoreAdapter.addData(strings);
                }
            };
            super.SetOnLoadMoreListener(onLoadMoreListener);
        }
        return loadTestMoreAdapter;
    }


    private class LoadTestMoreAdapter extends BaseRecycleAdapter<String> {
        //   public TextView tv_joke_des;

        //        @Override
//        protected void setChildView(View itemView) {
//            tv_joke_des = itemView.findViewById(R.id.tv_joke_des);
//        }


        @Override
        protected RecyclerView.ViewHolder getChildViewHolder(View view) {
            return new LoadTestMoreHolder(view);
        }

        @Override
        protected int getChildFragmentLayout(ViewGroup parent, int viewType) {
            return R.layout.test_layout;
        }

        //        @Override
//        public void setBindViewHolder(BaseRecycleAdapter.ViewHolder holder, int position) {
//            ArrayList<String> data = getData();
//            Log.d("tag","------position----"+position);
//            String s = data.get(position);
//            tv_joke_des.setText(s);
//        }
        int i = 0;
//      @Override
//      public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
//          super.onBindViewHolder(holder, position);
//          //   testHolder.tv_test_load.setText(s);
//      }

        @Override
        public void setBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            i += 1;
            Log.d("tag", "----------你会走几次------------------" + i);
            ArrayList<String> data = getData();
            Log.d("tag", "------position----" + position + "----------条目的总数----------" + getItemCount());
            String s = data.get(position);
            //  TestHolder testHolder=(TestHolder)holder;
            LoadTestMoreHolder testHolder = (LoadTestMoreHolder) holder;
            testHolder.tv_joke_des.setText(s);
        }

        @Override
        public void onViewRecycled(RecyclerView.ViewHolder holder) {
            super.onViewRecycled(holder);

        }

        private class LoadTestMoreHolder extends RecyclerView.ViewHolder {
            public TextView tv_joke_des;

            public LoadTestMoreHolder(View view) {
                super(view);
                tv_joke_des = view.findViewById(R.id.tv_joke_des);
            }
        }
    }


}
