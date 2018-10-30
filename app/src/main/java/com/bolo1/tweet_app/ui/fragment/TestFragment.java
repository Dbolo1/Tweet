package com.bolo1.tweet_app.ui.fragment;

import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.bolo1.tweet_app.R;
import com.bolo1.tweet_app.adapter.BaseRecycleAdapter;
import com.bolo1.tweet_app.adapter.LoadMoreAdapter;
import com.bolo1.tweet_app.bean.Article;
import com.bolo1.tweet_app.bean.Joke;
import com.bolo1.tweet_app.bean.PostFromService;
import com.bolo1.tweet_app.bean.SubjectInfo;
import com.bolo1.tweet_app.holder.TestHolder;
import com.bolo1.tweet_app.http.Api;
import com.bolo1.tweet_app.http.GetNetApi;
import com.bolo1.tweet_app.http.NetToService;
import com.bolo1.tweet_app.http.NetWorkCode;
import com.bolo1.tweet_app.http.OkHttpUtil;
import com.bolo1.tweet_app.ui.recycle.BaseRecycleFragment;
import com.bolo1.tweet_app.ui.uitls.LogUtils;
import com.bolo1.tweet_app.ui.uitls.StringUtils;
import com.bolo1.tweet_app.ui.uitls.ToastUtil;
import com.google.gson.Gson;

import org.json.JSONArray;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.plugins.RxJavaPlugins;
import rx.schedulers.Schedulers;

import static com.bolo1.tweet_app.ui.uitls.UIUtils.runOnUiThread;

/**
 * Created by 菠萝 on 2018/5/2.
 */

public class TestFragment extends BaseRecycleFragment {
    private TestFragmentAdapter adapter;
    private int mCurrentPage = 1;
    private Subscriber<Joke> subscriber;
    private static Api api;


    @Override
    protected void upDataOfView(Message msg) {

    }

//    private Subscriber getSubscriber() {
//        if (subscriber == null) {
//            subscriber = new Subscriber<Joke>() {
//                @Override
//                public void onCompleted() {
//                    mCurrentPage++;
//                    ToastUtil.show(getActivity(), "获取结束");
//                }
//                @Override
//                public void onError(Throwable e) {
//                }
//                @Override
//                public void onNext(Joke joke) {
//                    Joke.ShowapiResBodyBean showapi_res_body = joke.getShowapi_res_body();
//                    List<Joke.ShowapiResBodyBean.ContentlistBean> contentlist = showapi_res_body.getContentlist();
//                    LogUtils.e("test fragment ===" + joke.getShowapi_res_body().toString());
//                    adapter.addData(contentlist);
//                }
//            };
//        }
//        return subscriber;
//    }


    @Override
    public void sendRequestData() {
        LogUtils.e("sendRequestData size " + mCurrentPage);
        //  pn=1&rn=10&tag1=美女&tag2=全部&ftags=小清新&ie=utf8
            //运用rxjava
//        getApi().getJoke(10, mCurrentPage, NetWorkCode.JOKE_API, NetWorkCode.JOKE_API_SIGN)
//                .subscribeOn(Schedulers.io())
//                .observeOn(Schedulers.from(new Executor() {
//                    @Override
//                    public void execute(@android.support.annotation.NonNull Runnable command) {
//                        runOnUiThread(command);
//                    }
//                }))
//                .subscribe(getSubscriber());

            GetNetApi.getApi(NetWorkCode.GET_JOKE).getJoke(10, mCurrentPage, NetWorkCode.JOKE_API, NetWorkCode.JOKE_API_SIGN)
                    .enqueue(new Callback<Joke>() {
                        @Override
                        public void onResponse(Call<Joke> call, Response<Joke> response) {
                            LogUtils.e("执行了段子"+call.request().url()
                            );
                            if(response.isSuccessful()) {
                                Joke.ShowapiResBodyBean showapi_res_body = response.body().getShowapi_res_body();
                                List<Joke.ShowapiResBodyBean.ContentlistBean> contentlist = showapi_res_body.getContentlist();
                                LogUtils.e("test fragment ===" + response.body().getShowapi_res_body().toString());
                                if (showapi_res_body != null) {
                                    mCurrentPage++;
                                    adapter.addData(contentlist);
                                }
                            }
                        }
                        @Override
                        public void onFailure(Call<Joke> call, Throwable t) {
                                call.cancel();
                                t.printStackTrace();
                        }
                    });


    }

//    @Override
//    protected ArrayList<Article> parseList(String response) throws Exception {
//        ArrayList<Article> jokes = new ArrayList<>();
//        JSONArray ja = new JSONArray(response);
//        for (int i = 0; i < ja.length(); i++) {
//            String body = ja.getJSONObject(i).toString();
//            Article joke = new Gson().fromJson(body, Article.class);
//            //根据user_id查找用户信息,根据文本id查找评论数
////            String user_id = joke.getUser_id();
////            String joke_id = joke.getJoke_Id();
//            //查询数据库
//            //先显示效果吧
//            if (joke.getArticle_type() != 3) {
//                jokes.add(joke);
//            }
//        }
//        Log.d("test", "test____tostring======" + jokes.toString());
//
//        return jokes;
//    }

    @Override
    public BaseRecycleAdapter getChildAdapter() {
        adapter = new TestFragmentAdapter();
        OnLoadMoreListener onLoadMoreListener = new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                sendRequestData();
            }
        };
        super.SetOnLoadMoreListener(onLoadMoreListener);
        return adapter;
    }

    public class TestFragmentAdapter extends BaseRecycleAdapter<Joke.ShowapiResBodyBean.ContentlistBean> {
        {
            super.setChildPageSize(pageSize);
        }

        @Override
        protected RecyclerView.ViewHolder getChildViewHolder(View view) {
            return new TestHolder(view);
        }

        @Override
        protected int getChildFragmentLayout(ViewGroup parent, int viewType) {
            return R.layout.test_layout;
        }

        @Override
        public void setBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ArrayList<Joke.ShowapiResBodyBean.ContentlistBean> data = getData();
            if (data.size() != 0) {
                if (holder instanceof TestHolder) {
                    TestHolder testHolder = (TestHolder) holder;
                    Joke.ShowapiResBodyBean.ContentlistBean contentlistBean = data.get(position);
                    testHolder.tv_joke_des.setText(contentlistBean.getText());
//                tv_user_name.setText(article.set);
                    ////---------------------评论的点击-------------------------------------------
                    testHolder.tv_des_comments.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ToastUtil.show(getActivity(), "评论");
                        }
                    });
                    testHolder.tv_des_dislike.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ToastUtil.show(getActivity(), " 踩");
                        }
                    });
                    testHolder.tv_des_like.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ToastUtil.show(getActivity(), "顶");
                        }
                    });
                    ////---------------------------------------------
                }
            }

        }
    }

}
