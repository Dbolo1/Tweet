package com.bolo1.tweet_app.adapter;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bolo1.tweet_app.MainActivity;
import com.bolo1.tweet_app.R;
import com.bolo1.tweet_app.bean.Article;
import com.bolo1.tweet_app.bean.Home;
import com.bolo1.tweet_app.bean.ShortVideo;
import com.bolo1.tweet_app.common.PlayerManager;
import com.bolo1.tweet_app.holder.CommentHolder;
import com.bolo1.tweet_app.holder.HomeHolder;
import com.bumptech.glide.Glide;
import com.dou361.ijkplayer.bean.VideoijkBean;
import com.dou361.ijkplayer.listener.OnShowThumbnailListener;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 菠萝 on 2018/7/18.
 */

public class HomeAdapter extends BaseRecycleAdapter<ShortVideo> {

    private final MainActivity activity;
    private HomeHolder homeHolder;
    private ArrayList<VideoijkBean> list;
    private PlayerView player;
    public PlayerManager playerManager;
    public MediaPlayer mediaPlayer;

    public HomeAdapter(Activity  activity){
        this.activity =(MainActivity)activity;
        ((MainActivity) activity).tb_home.setVisibility(View.GONE);
    }



    @Override
    protected RecyclerView.ViewHolder getChildViewHolder(View view) {
        return new HomeHolder(view);
    }

    @Override
    protected int getChildFragmentLayout(ViewGroup parent, int viewType) {
        return R.layout.home_layout;
    }
    List<PlayerManager> playerManagerList = new ArrayList<PlayerManager>();
    @Override
    public void setBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ArrayList<ShortVideo> data = getData();
        if(data.size()!=0){
        if(holder instanceof HomeHolder ){
            ShortVideo shortVideo = data.get(position);
            homeHolder = (HomeHolder) holder;
                ///添加好友同时执行动画 并且消失
           // homeHolder.iv_home_add

            Glide.with(activity).load("http://192.168.1.112:81/tweet/com.bolo1.tweet_app/news/image/A2.jpg").into(homeHolder.iv_home_author);
//                    homeHolder.iv_home_author.setImageBitmap();
            Glide.with(activity).load("http://192.168.1.112:81/tweet/com.bolo1.tweet_app/news/image/A2.jpg").into(homeHolder.iv_home_music);
            mediaPlayer = new MediaPlayer();

         //   mediaPlayer.start();
            //方案1 采用多线程 一条开启视频 一条开启音乐
//                            homeHolder.iv_home_music
//                                    homeHolder.iv_search_home
//                                            homeHolder.ll_home_main
//                                                    homeHolder.tv_home_author_name
//                                                            homeHolder.tv_home_comment
//                                                                    homeHolder.tv_home_like
//                                                                            homeHolder.tv_home_music_name
//                                                                                    homeHolder.tv_home_recommend
//                                                                                            homeHolder.tv_home_round
//                                                                                                    homeHolder.tv_home_share
//                                                                                                            homeHolder.tv_home_title
//


          //  setVideoPlayer(shortVideo,homeHolder);,
            FrameLayout.LayoutParams params =
                    new FrameLayout.LayoutParams
                            (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            homeHolder.ijk_home.setLayoutParams(params);
            playerManager = new PlayerManager(activity,homeHolder.ijk_home);
            playerManager.setScaleType(PlayerManager.SCALETYPE_FITXY);
            playerManager.setFullScreenOnly(false);
            playerManager.play(shortVideo.getVideo_url());
            playerManager.start();
        }

        }
    }

    /**
     * 配置视频信息
     *
     */
    private void setVideoPlayer(ShortVideo shortVideo, HomeHolder homeHolder) {
        list = new ArrayList<VideoijkBean>();
        VideoijkBean m1 = new VideoijkBean();
        m1.setStream("标清");
        m1.setUrl(shortVideo.getVideo_url());
        list.add(m1);
        player = new PlayerView(activity, homeHolder.itemView) {
            @Override
            public PlayerView toggleProcessDurationOrientation() {
                hideSteam(getScreenOrientation() == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                return setProcessDurationOrientation(getScreenOrientation() == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT ? PlayStateParams.PROCESS_PORTRAIT : PlayStateParams.PROCESS_LANDSCAPE);
            }

            @Override
            public PlayerView setPlaySource(List<VideoijkBean> list) {
                return super.setPlaySource(list);
            }
        }
                .setProcessDurationOrientation(PlayStateParams.PROCESS_PORTRAIT)
                .setScaleType(PlayStateParams.fillparent)
                .forbidTouch(false)
                .hideSteam(true)
                .hideCenterPlayer(false)
                .showThumbnail(new OnShowThumbnailListener() {
                    @Override
                    public void onShowThumbnail(ImageView ivThumbnail) {
                        Glide.with(activity)
                                .load("http://pic2.nipic.com/20090413/406638_125424003_2.jpg")
                                .placeholder(R.color.cl_default)
                                .error(R.color.cl_error)
                                .into(ivThumbnail);
                    }
                })
                .setPlaySource(list);

    }





}
