package com.bolo1.tweet_app.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bolo1.tweet_app.R;
import com.bolo1.tweet_app.ui.uitls.LogUtils;


import java.util.ArrayList;

/**
 * Created by 菠萝 on 2018/5/17.
 */

public class LoadMoreAdapter extends BaseRecycleAdapter {
    private BaseRecycleAdapter adapter;
    private int mPagePosition = 0;
    private boolean hasMoreData = true;
    private static int  mCurrentPage = 0;
    private static final int mPageSize = 10;
    private OnLoad onLoad;
    private LoadMoreItemVH loadMoreItemVH;
    private LoadNOMoreItemVH loadNOMoreItemVH;


    public LoadMoreAdapter(BaseRecycleAdapter adapter, OnLoad onLoad) {
        this.adapter = adapter;
        this.onLoad = onLoad;
    }

//    @Override
//    protected void setChildView(View itemView) {
////        if(itemView.get)
//        LogUtils.d("获得的资源文件id==" + itemView.getId());
//
////        adapter.setChildView(itemView);
//    }

    @Override
    public int getItemCount() {
        return adapter.getItemCount() + 1;
    }


    @Override
    public int getItemViewType(int position) {
        if(getItemCount()-1==0){
            //走一个帧动画
            return R.layout.load_empty_layout;
        }else if (position == getItemCount() - 1) {
//            ArrayList data = adapter.getData();
//            LogUtils.d("你item个数为多少"+adapter.getItemCount()+"getData"+data.size());
            if (hasMoreData) {
                return R.layout.load_foot_layout;
            } else {
                return R.layout.load_no_more_layout;
            }
        } else {
            LogUtils.d("你这里没有item 所有只会加载根布局");
            return adapter.getItemViewType(position);
        }
    }

    @Override
    protected int getChildFragmentLayout(ViewGroup parent, int viewType) {
        return adapter.getChildFragmentLayout(parent,viewType);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == R.layout.load_foot_layout) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.load_foot_layout, parent, false);
            loadMoreItemVH = new LoadMoreItemVH(view);
            return loadMoreItemVH;
        } else if (viewType == R.layout.load_no_more_layout) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.load_no_more_layout, parent, false);
            loadNOMoreItemVH = new LoadNOMoreItemVH(view);
            return loadNOMoreItemVH;
        }else if(viewType == R.layout.load_empty_layout) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.load_empty_layout, parent, false);
            loadNOMoreItemVH = new LoadNOMoreItemVH(view);
            return loadNOMoreItemVH;
        } else {
            return adapter.onCreateViewHolder(parent, viewType);
        }


    }

    @Override
    protected RecyclerView.ViewHolder getChildViewHolder(View view) {
        return new LoadMoreItemVH(view);
    }

//    @Override
//    public void setBindViewHolder(ViewHolder holder, int position) {
//
//    }

//    @Override
//    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        if (holder == loadMoreItemVH) {
//            requestData(mPagePosition, mPageSize);
//        } else if (holder == loadNOMoreItemVH) {
//
//        } else {
//            adapter.onBindViewHolder(holder, position);
//        }
//    }

    @Override
    public void setBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder == loadMoreItemVH) {
            requestData(mPagePosition, mPageSize);
        } else if (holder == loadNOMoreItemVH) {

        } else {
            adapter.onBindViewHolder(holder, position);
        }
    }

    private void requestData(int pagePosition,int pageSize) {
        if (onLoad != null) {
            onLoad.load(pagePosition, pageSize, new ILoadCallback() {
                @Override
                public void onSuccess() {
                 //   notifyDataSetChanged();
//                    mPagePosition = mPagePosition+mPageSize;
//                    mCurrentPage++;
                    hasMoreData = true;
                }
                @Override
                public void onFailure() {

                    hasMoreData = false;
                }
            });
        }
    }


    /***********加载回调*****************/
    public interface OnLoad {
        void load(int mPosition, int pageSize, ILoadCallback callback);

    }

    public interface ILoadCallback {
        void onSuccess();

        void onFailure();
    }


    public class LoadMoreItemVH extends RecyclerView.ViewHolder {

        public LoadMoreItemVH(View itemView) {

            super(itemView);
        }

    }

    public class LoadNOMoreItemVH extends RecyclerView.ViewHolder {

        public LoadNOMoreItemVH(View itemView) {
            super(itemView);
        }
    }

}
