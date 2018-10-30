package com.bolo1.tweet_app.ui.fragment;

import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.bolo1.tweet_app.MainActivity;
import com.bolo1.tweet_app.R;
import com.bolo1.tweet_app.adapter.BaseRecycleAdapter;
import com.bolo1.tweet_app.adapter.HomeAdapter;
import com.bolo1.tweet_app.bean.Article;
import com.bolo1.tweet_app.bean.Home;
import com.bolo1.tweet_app.bean.PostFromService;
import com.bolo1.tweet_app.bean.ShortVideo;
import com.bolo1.tweet_app.http.NetToService;
import com.bolo1.tweet_app.http.NetWorkCode;
import com.bolo1.tweet_app.ui.recycle.BaseRecycleFragment;
import com.google.gson.Gson;

import org.json.JSONArray;

import java.util.ArrayList;

import static android.R.style.Theme;
import static android.R.style.Theme_Holo_NoActionBar_Fullscreen;

/**
 * Created by 菠萝 on 2018/7/18.
 */

public class ShortVideoFragment extends BaseRecycleFragment {
    private PostFromService pfs;
    private int ShortVideoFragment_CurrentPage=0;
    private int pageSize=5;
    private NetToService netToService;
    private HomeAdapter homeAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity activity = (MainActivity)getActivity();
      //  activity.requestWindowFeature(Window.FEATURE_NO_TITLE);
//去掉Activity上面的状态栏
        activity.getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN , WindowManager.LayoutParams. FLAG_FULLSCREEN);

    }


    @Override
    protected void upDataOfView(Message msg) {

    }

    @Override
    public void sendRequestData() {

        ArrayList<ShortVideo> articles =new ArrayList<>();
        ShortVideo shortVideo = new ShortVideo();
        shortVideo.setVideo_url("http://192.168.1.112:81/tweet/com.bolo1.tweet_app/news/video/meinv1.mp4");
        articles.add(shortVideo);
        homeAdapter.addData(articles);

    }

    @Override
    public BaseRecycleAdapter getChildAdapter() {
        homeAdapter = new HomeAdapter((MainActivity)getActivity());
        return homeAdapter;
    }

    @Override
    protected ArrayList<ShortVideo> parseList(String response) throws Exception {
        ArrayList<ShortVideo> homes = new ArrayList<>();
        JSONArray ja = new JSONArray(response);
        for (int i = 0; i < ja.length(); i++) {
            String body = ja.getJSONObject(i).toString();
            ShortVideo home = new Gson().fromJson(body, ShortVideo.class);
            homes.add(home);
        }
        Log.d("test", "test____tostring======" + homes.toString());

        return homes;
    }

    @Override
    public void onStop() {
        super.onStop();

    }

    @Override
    public void onStart() {
        super.onStart();


    }

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public void onResume() {
        super.onResume();

    }
}
