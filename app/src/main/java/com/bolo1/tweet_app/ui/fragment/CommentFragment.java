package com.bolo1.tweet_app.ui.fragment;

import android.os.Message;
import android.util.Log;

import com.bolo1.tweet_app.MainActivity;
import com.bolo1.tweet_app.adapter.BaseRecycleAdapter;
import com.bolo1.tweet_app.adapter.CommentAdapter;
import com.bolo1.tweet_app.adapter.LoadMoreAdapter;
import com.bolo1.tweet_app.bean.Article;
import com.bolo1.tweet_app.bean.PostFromService;
import com.bolo1.tweet_app.bean.Video;
import com.bolo1.tweet_app.http.NetToService;
import com.bolo1.tweet_app.http.NetWorkCode;
import com.bolo1.tweet_app.ui.recycle.BaseRecycleFragment;
import com.bolo1.tweet_app.ui.uitls.LogUtils;
import com.bolo1.tweet_app.ui.uitls.ToastUtil;
import com.google.gson.Gson;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 菠萝 on 2018/5/21.
 */

public class CommentFragment extends BaseRecycleFragment {

    private CommentAdapter commentAdapter;
    public static boolean isHasMore;
    private PostFromService pfs;
    private  int TweetFragment_mCurrentPage = 1;
    private static final int pageSize = 15;
    private NetToService netToService;

    @Override
    protected void upDataOfView(Message msg) {
    }

    @Override
    public void sendRequestData() {






        pfs = new PostFromService();
        pfs.setType(NetWorkCode.GET_VIDEO);
        pfs.setCurrentPage(TweetFragment_mCurrentPage);
        if (netToService == null) {
            netToService = new NetToService(pfs, new NetToService.OnCallBackServiceData() {
                @Override
                public void onFailure(String s) {
                    isHasMore = false;
                }

                @Override
                public void onSucceed(Object objects) {
                    try {
                        ArrayList<Video.DataBean> articles = parseList(objects.toString());
                        LogUtils.e("video==" + articles.toString());
                        if (isHasMore) {
                            TweetFragment_mCurrentPage++;
                        }
                        commentAdapter.addData(articles);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        Thread thread = new Thread(netToService);
        thread.start();
    }

    ////------------这里可以抽取   暂时未想到怎么抽取-----
    @Override
    protected ArrayList<Video.DataBean> parseList(String response) throws Exception {
        ///这里我只要type类型为3的数据
        Gson gson = new Gson();
        Video video = gson.fromJson(response, Video.class);
        isHasMore = video.isHasNext();
        return video.getData();
    }
    @Override
    public BaseRecycleAdapter getChildAdapter() {
        MainActivity activity = (MainActivity) getActivity();
        commentAdapter = new CommentAdapter(activity);
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
        return commentAdapter;
    }


}
