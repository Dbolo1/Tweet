package com.bolo1.tweet_app.ui.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bolo1.tweet_app.MainActivity;
import com.bolo1.tweet_app.R;
import com.bolo1.tweet_app.adapter.BaseRecycleAdapter;

import com.bolo1.tweet_app.adapter.LoadMoreAdapter;
import com.bolo1.tweet_app.bean.Article;
import com.bolo1.tweet_app.bean.News;
import com.bolo1.tweet_app.bean.News_Data;
import com.bolo1.tweet_app.bean.PostFromService;
import com.bolo1.tweet_app.holder.TweetHolder;
import com.bolo1.tweet_app.http.GetNetApi;
import com.bolo1.tweet_app.http.NetToService;
import com.bolo1.tweet_app.http.NetWorkCode;
import com.bolo1.tweet_app.ui.ArticleDesActivity;
import com.bolo1.tweet_app.ui.recycle.BaseRecycleFragment;
import com.bolo1.tweet_app.ui.uitls.ConstantValue;
import com.bolo1.tweet_app.ui.uitls.LogUtils;
import com.bolo1.tweet_app.ui.uitls.ToastUtil;
import com.bolo1.tweet_app.ui.uitls.UIUtils;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;


import java.util.ArrayList;
import java.util.Iterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 菠萝 on 2018/4/20.
 */

public class TweetFragment extends BaseRecycleFragment {
    private static int TweetFragment_pagePosition = 10;
    private static int mPosition = 0;
    private int TweetFragment_mCurrentPage = 1;
    private static final int pageSize = 15;
    private ArrayList<News_Data> datas = new ArrayList<>();
    private TweetRecycleAdapter tweetRecycleAdapter;

    private PostFromService pfs;
    private NetToService netToService;
    private Bitmap bitmap;


    @Override
    protected void upDataOfView(Message msg) {
        ///  LogUtils.d("数据获取到了" + msg.obj.toString());
        ArrayList<News> newses = (ArrayList<News>) msg.obj;
        Toast.makeText(UIUtils.getContext(), "数据获取到了", Toast.LENGTH_SHORT).show();
    }

    private boolean isNet = true;

    @Override
    public void sendRequestData() {
        //对网络进封装
//        if (isNet) {
//            if (pfs == null) {
//                pfs = new PostFromService();
//            }
//            pfs.setType(NetWorkCode.NEWS);
//            pfs.setCurrentPage(TweetFragment_mCurrentPage);
//            if (netToService == null) {
//                netToService = new NetToService(pfs, new NetToService.OnCallBackServiceData() {
//                    @Override
//                    public void onFailure(String s) {
//                        isHasMore = false;
//                    }
//
//                    @Override
//                    public void onSucceed(Object objects) {
//
//                        ////调用新闻接口
//                        Gson gson = new Gson();
//                        News news = gson.fromJson(objects.toString(), News.class);
//                      //  ArrayList<News_Data> data = news.getData();
//                        isHasMore = news.hasNext;
//                        Log.d("tag", "过的的数据onSucceed======" + objects.toString()+"--------"+isHasMore);
//                        if (isHasMore) {
//                            TweetFragment_mCurrentPage++;
//                        }
//                        tweetRecycleAdapter.addData(news.getData());
//                        LogUtils.d("获得数据的大小===" + tweetRecycleAdapter.getData().size());
//                    }
//                });
//            }
//            //暂时未使用线程池
//            LogUtils.d("TweetFragment请求数据");
//            Thread thread = new Thread(netToService);
//            thread.start();
//            tweetRecycleAdapter.notifyDataSetChanged();
//        }

        GetNetApi.getApi(NetWorkCode.NEWS_URL)
                .getNews(NetWorkCode.NEWS_URL_kw, TweetFragment_mCurrentPage, NetWorkCode.NEWS_URL_site,NetWorkCode.NEWS_API_KEY)
                .enqueue(new Callback<News>() {
                    @Override
                    public void onResponse(Call<News> call, Response<News> response) {
                        if (response.isSuccessful()) {
                            News news = response.body();
                            isHasMore = news.hasNext;
                            if (isHasMore) {
                                TweetFragment_mCurrentPage++;
                            }
                            tweetRecycleAdapter.addData(news.getData());
                            LogUtils.d("获得数据的大小===" + tweetRecycleAdapter.getData().size());
                        }
                    }

                    @Override
                    public void onFailure(Call<News> call, Throwable t) {
                        LogUtils.e("TweetFragment-====" +call.request().url());
                        call.cancel();
                        t.printStackTrace();
                    }
                });
    }

    private boolean isHasMore = false;

    @Override
    public BaseRecycleAdapter getChildAdapter() {
        LogUtils.d("获取适配器");
        tweetRecycleAdapter = new TweetRecycleAdapter();
        OnLoadMoreListener onLoadMoreListener = new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                if (isHasMore) {
                    sendRequestData();
                } else {
                    ToastUtil.show(getActivity(), "没有更多数据了");
                }
            }
        };
        super.SetOnLoadMoreListener(onLoadMoreListener);
        return tweetRecycleAdapter;
    }
    //在这fragment里面解析数据


    public class TweetRecycleAdapter extends BaseRecycleAdapter<News_Data> {
        {
            super.setChildPageSize(TweetFragment.pageSize);
        }

        ////两种item type  一 图片与tile 二 tile与des
//        @Override
//        protected void setChildView(View itemView) {
//            ButterKnife.inject(this, itemView);
//        }
        @Override
        protected RecyclerView.ViewHolder getChildViewHolder(View view) {
            return new TweetHolder(view);
        }

        @Override
        protected int getChildFragmentLayout(ViewGroup parent, int viewType) {
            return R.layout.news_main_layout;
        }


        @Override
        public ArrayList<News_Data> getData() {
            //    LogUtils.d("获取数据=====");
            return super.getData();
        }

        @Override
        public void setBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            MainActivity activity = (MainActivity) getActivity();
            ArrayList<News_Data> data = getData();

            if (data.size() != 0) {
                if (holder instanceof TweetHolder) {
                    final TweetHolder tweetHolder = (TweetHolder) holder;
                    LogUtils.d("tweet数据-d的大小----" + data.size());
                    final News_Data news_data_content = data.get(position);
                    tweetHolder.ll_news_item_1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent();
                            intent.putExtra(ConstantValue.NEWS_DES_URL, news_data_content.getUrl());
                            intent.setClass(getActivity(), NewsDesActivity.class);
                            startActivity(intent);
                        }
                    });
//                       /////------@注释放在注释目录TweetFragment
                    tweetHolder.tv_news_item_1_title_1.setText(news_data_content.title);
                    tweetHolder.tv_news_item_1_date_1.setText(news_data_content.publishDateStr);
                    tweetHolder.tv_news_item_1_des.setText(news_data_content.content);
                    tweetHolder.tv_news_item_1_comments_1.setText(news_data_content.getCommentCount());
                    ArrayList<String> imageUrls = news_data_content.getImageUrls();
                    if (imageUrls != null && imageUrls.size() != 0) {
                        //设置图片
                        tweetHolder.ll_news_item_1_image.setVisibility(View.VISIBLE);
                        Glide.with(activity).load(imageUrls.get(0)).into(tweetHolder.iv_news_item_image_1);
                    } else {
                        tweetHolder.ll_news_item_1_image.setVisibility(View.GONE);
                    }
                }
            }
        }


    }

    /*******************这是回调load******************/

}
