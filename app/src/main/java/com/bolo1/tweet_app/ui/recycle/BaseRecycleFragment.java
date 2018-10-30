package com.bolo1.tweet_app.ui.recycle;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bolo1.tweet_app.MainActivity;
import com.bolo1.tweet_app.R;
import com.bolo1.tweet_app.adapter.BaseRecycleAdapter;
import com.bolo1.tweet_app.adapter.HomeAdapter;
import com.bolo1.tweet_app.cache.CacheManager;
import com.bolo1.tweet_app.http.NetworkUrl;
import com.bolo1.tweet_app.ui.uitls.LogUtils;

import java.io.Serializable;
import java.lang.ref.WeakReference;

import butterknife.ButterKnife;
import butterknife.InjectView;

import static android.R.style.Theme_Holo_NoActionBar_Fullscreen;

/**
 * Created by 菠萝 on 2018/5/3.
 */

public abstract class BaseRecycleFragment<T> extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    @InjectView(R.id.srl_base_home)
    SwipeRefreshLayout srl_base_home;
    @InjectView(R.id.rv_base_home)
    RecyclerView rv_base_home;
//    protected  int mPosition=0;
//    protected  int mPageSize=10;
    protected  int mCurrentPage=1;
    public boolean isHashMore;
    public static final int STATE_NONE = 0;

    public static final int STATE_REFRESH = 1;
    public static final int STATE_LOADMORE = 2;
    public static final int STATE_NOMORE = 3;
    public static final int STATE_PRESSNONE = 4;// 正在下拉但还没有到刷新的状态
    public static int mState = STATE_NONE;
    private AsyncTask<String, Void,T> mCacheTask;
    private BaseRecycleAdapter childAdapter;

    protected Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (mLoadMoreListener!=null){
                mLoadMoreListener.onLoadMore();
            }
            childAdapter.notifyDataSetChanged();
            upDataOfView(msg);
        }
    };
    private MainActivity activity;

    protected abstract void upDataOfView(Message msg);

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (MainActivity)getActivity();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), null);
        ButterKnife.inject(this, view);
        initView(view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        onRefresh();
    }

    private void initView(View view) {
        srl_base_home.setOnRefreshListener(this);
        srl_base_home.setColorSchemeResources(
                R.color.swipe_refresh_color1, R.color.swipe_refresh_color2,
                R.color.swipe_refresh_color3, R.color.swipe_refresh_color4
        );
        LinearLayoutManager lm = new LinearLayoutManager(getContext());

        lm.setOrientation(getRecycleViewOrientation());
        rv_base_home.setLayoutManager(lm);
        //需要子类返回一个adapter
        LogUtils.d("CommentFragment_这里走了没有啊————————————————————"+(NetworkUrl.URL + NetworkUrl.CommentFragment + NetworkUrl._JSON));

        childAdapter = getChildAdapter();
//        rv_base_home.setAdapter(new CommonAdapter<String>(Datas,R.layout.item_view)
//        {
//            @Override
//            protected void setupViewHolder(RecyclerViewHolder recyclerViewHolder, int i, String s) {
//                LogUtils.d("执行到这里了recyclerViewHolder");
//               recyclerViewHolder.getView(R.id.tv_view_test);

//            }

//            @Override
//            public void convert(BaseRecycleAdapter.ViewHolder holder, String s)
//            {
//                holder.setText(R.id.id_item_list_title, s);
//            }
//        });

        if (childAdapter != null) {
//            SimpleAdapter simpleAdapter = new SimpleAdapter(UIUtils.getContext(), list, android.R.layout.simple_list_item_1,
//                    new String[]{"Name", "age"}, new int[]{android.R.id.text1, android.R.id.text2});
            rv_base_home.setAdapter(childAdapter);

            childAdapter.setOnItemClickListener(new BaseRecycleAdapter.OnItemClickListener() {
                @Override
                public void onClick(int position) {
                    LogUtils.d("点击位置p==" + position);
                }

                @Override
                public void onLongClick(int position) {
                    LogUtils.d("长按位置p==" + position);
                }
            });
//
            rv_base_home.setOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    if(newState==RecyclerView.SCROLL_STATE_IDLE&&BaseRecycleAdapter.TYPE_HOLDER_STATE==BaseRecycleAdapter.TYPE_HOLDER_FOOT){
                        //加载更多
                        Log.d("tag","你走了加载更多了没有");
                        //    handler.sendEmptyMessage(0);
                        handler.sendEmptyMessageDelayed(0,2000);
                    }
                    childAdapter.setOnCallBackPosition(new BaseRecycleAdapter.OnCallBackPosition() {
                        @Override
                        public void getPosition(int position) {
                            if(position==childAdapter.getItemCount()-1){
                                BaseRecycleAdapter.TYPE_HOLDER_STATE=BaseRecycleAdapter.TYPE_HOLDER_FOOT;
                            }else {
                                BaseRecycleAdapter.TYPE_HOLDER_STATE=BaseRecycleAdapter.TYPE_HOLDER_NORMAL;
                            }
                        }
                    });

                   // super.onScrollStateChanged(recyclerView, newState);
                }

                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                }
            });
        }
        //需要取得数据勒
        if (isCreateViewOfData()) {
            mState = STATE_NONE;
            requestData(false);
        }

    }


    ///解析选择json 导包gson
    private void requestData(boolean refresh) {
        //获得缓存key
        String cacheKey = getCacheKey();
        //写入缓存
        if (refresh) {
            //如果需要读取缓存则判断缓存是否有效
            readCacheData(cacheKey);
        } else {
            //暂时不写入缓存
            sendRequestData();
            setSwipeRefreshLoadedState();
        }
    }

    private void readCacheData(String cacheKey) {
        // 使用异步任务处理
        cancelCacheTask();
        mCacheTask = new CacheTask(getContext()).execute(cacheKey);

    }

    private void cancelCacheTask() {
        if (mCacheTask != null) {
            mCacheTask.cancel(true);
            mCacheTask = null;
        }
    }

//    protected ListEntity<T> parseList(InputStream in) throws Exception {
//        return null;
//    }
    // protected abstract  void  parseList(InputStream in);

    protected  T parseList(String response) throws Exception {
        return null;
    }


    protected T readList(Serializable ser) {
        return null;
    }

    private String getCacheKey() {

        String string = new StringBuilder(getCachePreFix()).append("_").append(mCurrentPage).toString();

        return string;
    }

    private String getCachePreFix() {
        return "";
    }

    private int getLayoutId() {
        return R.layout.base_recycle_layout;
    }

    /*******************刷新去重 暂时不写************************/
    @Override
    public void onRefresh() {
        //这里做刷新操作
        LogUtils.d("当前的滑动状态==="+mState);
        if(mState==STATE_REFRESH){
            return;
        }
        //滚动到顶部
     //   rv_base_home.smoothScrollToPosition(0);
        rv_base_home.setEnabled(false);
        setSwipeRefreshLoadingState();
        LogUtils.d("onRefresh===mState="+mState);

    }
    /**
     * 设置顶部正在加载的状态
     */
    private void setSwipeRefreshLoadingState() {
       // mState = STATE_REFRESH;
        if (srl_base_home!= null) {
            srl_base_home.setRefreshing(true);
            // 防止多次重复刷新
            srl_base_home.setEnabled(false);
        }
        LogUtils.d("顶部正在加载的状态===mState="+mState);
    }

    /**
     * 设置顶部加载完毕的状态
     */
    private void setSwipeRefreshLoadedState() {
       mState = STATE_NONE;
        if (srl_base_home != null) {
            srl_base_home.setRefreshing(false);
            srl_base_home.setEnabled(true);
        }
        rv_base_home.setEnabled(true);
        LogUtils.d("顶部加载完毕的状态===mState="+mState);
    }


//    public  void sendRequestData(){
//        switch (NetWorkCode.code){
//            case NetWorkCode.Get:
//                NetworkHelper.getDataOfService(getDataUrlParameter());
//                break;
//            case NetWorkCode.Post:
//                break;
//        }
//    }

    public abstract  void sendRequestData();

    protected String getDataUrlParameter(){
        return "";
    }

    public abstract BaseRecycleAdapter<T> getChildAdapter();

    public int getRecycleViewOrientation() {
        return LinearLayoutManager.VERTICAL;
    }

    public boolean isCreateViewOfData() {
        return true;
    }

    private class CacheTask extends AsyncTask<String, Void, T> {

        private final WeakReference<Context> mContext;

        public CacheTask(Context context) {
            mContext = new WeakReference<>(context);
        }

        @Override
        protected T doInBackground(String... params) {
            Serializable ser = CacheManager.readObject(getContext(), params[0]);
            if (ser == null) {
                return null;
            } else {
                return readList(ser);
            }

        }

        @Override
        protected void onPostExecute(T list) {
            super.onPostExecute(list);
            if (list != null) {
                executeOnLoadDataSuccess(list);
            } else {
                executeOnLoadDataError(null);
            }
            executeOnLoadFinish();
        }


    }

    private void executeOnLoadFinish() {
        //加载完成

    }


    private void executeOnLoadDataError(Object o) {
        //加载数据失败

    }

    private void executeOnLoadDataSuccess(T data) {
        //成功加载数据
        LogUtils.e("缓存数据---"+data.toString());
    }

////----------mLoadMoreListener 加载更多回调--------------------
    private OnLoadMoreListener mLoadMoreListener;
    protected void SetOnLoadMoreListener(OnLoadMoreListener mLoadMoreListener){
        this.mLoadMoreListener=mLoadMoreListener;
    }
    public interface OnLoadMoreListener {
       void onLoadMore();
    }
}
