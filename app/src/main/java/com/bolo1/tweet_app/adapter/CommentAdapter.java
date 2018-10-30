package com.bolo1.tweet_app.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.nfc.Tag;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.bolo1.tweet_app.R;
import com.bolo1.tweet_app.bean.Article;
import com.bolo1.tweet_app.bean.Game;
import com.bolo1.tweet_app.bean.News;
import com.bolo1.tweet_app.bean.Video;
import com.bolo1.tweet_app.common.PlayerManager;
import com.bolo1.tweet_app.holder.CommentHolder;
import com.bolo1.tweet_app.media.AndroidMediaController;
import com.bolo1.tweet_app.media.IjkVideoView;
import com.bolo1.tweet_app.ui.fragment.CommentFragment;
import com.bolo1.tweet_app.ui.uitls.LogUtils;
import com.bolo1.tweet_app.ui.uitls.ToastUtil;
import com.bolo1.tweet_app.ui.uitls.UIUtils;
import com.bumptech.glide.Glide;
import com.dou361.ijkplayer.bean.VideoijkBean;
import com.dou361.ijkplayer.listener.OnShowThumbnailListener;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;

import org.w3c.dom.Text;


import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/**
 * Created by 菠萝 on 2018/5/22.
 */


public class CommentAdapter extends BaseRecycleAdapter<Video.DataBean> {
    private String tag = CommentAdapter.class.getSimpleName();
    private final Activity activity;
    //    private Article video_news;
    // private PlayerManager player;
    private MediaMetadataRetriever mmr;
    private static int STATE_PLAY = 1;
    private static int STATE_STOP = 2;
    private static int STATE_PUASE = 3;
    private static int STATE_LOAD = 4;
    private static int STATE_PRE = 5;
    private static int STATE = STATE_PRE;
    private ArrayList<VideoijkBean> list;
    private PlayerView player;
    //    @Override
//    protected void setChildView(View itemView) {
//        vv_comment = itemView.findViewById(R.id.vv_comment);
//        ButterKnife.inject(this,itemView);
//    }


    @Override
    protected int getChildFragmentLayout(ViewGroup parent, int viewType) {

        return R.layout.comment_video_layout;
    }

    public CommentAdapter(Activity activity) {
        this.activity = activity;

    }

    List<PlayerManager> playerManagerList = new ArrayList<PlayerManager>();


    @Override
    public void setBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        LogUtils.d("你这里走了没2222");
        ArrayList<Video.DataBean> data = getData();

        if (data.size() != 0) {
            if (holder instanceof CommentHolder) {
                final CommentHolder comment_holder = (CommentHolder) holder;
                Video.DataBean dataBean = data.get(position);
                /**************找个集合把他们装起来************************/
//                //没有给videoview 封装管理器

                setVideoPlayer(dataBean, comment_holder, position);
                ///------------------------点击事件写外面获取不到posistion值的问题--------------------------------
                comment_holder.tv_comment_comments.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtil.show(activity, "你点击了评论位置" + position);
                    }
                });
                comment_holder.tv_comment_like.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtil.show(activity, "你点击了点赞位置" + position);
                    }
                });
                comment_holder.iv_comments_share.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtil.show(activity, "你点击了分享位置" + position);
                    }
                });
                ///不能这么写   应该用控制器去管理videoview 按道理应该写给装饰者
                //打tag  写给控制器
/**

 comment_holder.iv_video_play.setVisibility(View.VISIBLE);
 comment_holder.iv_video_play.setOnClickListener(new View.OnClickListener() {
@Override public void onClick(View v) {
//     player.play(video_news.getArticle_video_url());
for (int i = 0; i < playerManagerList.size(); i++) {
if (playerManagerList.get(i).isPlaying()) {
playerManagerList.get(i).onPause();
playerManagerList.get(i).stop();
}
}
//应该用多线程 //根据状态改变play图标
comment_holder.iv_video_play.setVisibility(View.INVISIBLE);
PlayerManager playerManager = playerManagerList.get(position);
playerManager.play(video_news.getArticle_video_url());
playerManager.start();
Toast.makeText(activity, "你点击播放第" + position + "个视频", Toast.LENGTH_SHORT).show();
// player.play(video_news.getArticle_video_url());
// playerManagerList.get(position).start();
}
});
 *
 */
            }
        }
    }

    private int position_tag;

    /**
     * 配置视频信息
     *
     * @param video_bean
     * @param comment_holder
     * @param position
     */
    private void setVideoPlayer(final Video.DataBean video_bean, CommentHolder comment_holder, int position) {
        //记录播放位置


        list = new ArrayList<VideoijkBean>();
        VideoijkBean m1 = new VideoijkBean();
        m1.setStream("标清");
        List<String> videoUrls = video_bean.getVideoUrls();
        m1.setUrl(videoUrls.get(0));
//        VideoijkBean m2 = new VideoijkBean();
//        m2.setStream("高清");
//        m2.setUrl(url2);
        list.add(m1);
//        list.add(m2);
        //  View rootView = getLayoutInflater(activity).from(activity).inflate(R.layout.activity_h, null);

        player = new PlayerView(activity, comment_holder.itemView) {
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
                .setTitle(video_bean.getTitle())
                .setProcessDurationOrientation(PlayStateParams.PROCESS_PORTRAIT)
                .setScaleType(PlayStateParams.fillparent)
                .forbidTouch(false)
                .hideSteam(true)
                .hideCenterPlayer(false)
                .showThumbnail(new OnShowThumbnailListener() {
                    @Override
                    public void onShowThumbnail(ImageView ivThumbnail) {
                        Glide.with(activity)
                                .load(video_bean.getCoverUrl())
                                .placeholder(R.color.cl_default)
                                .error(R.color.cl_error)
                                .into(ivThumbnail);
                    }
                })
                .setPlaySource(list)
                .setChargeTie(true, 60);


    }


    @Override
    protected RecyclerView.ViewHolder getChildViewHolder(View view) {
        return new CommentHolder(view);
    }


}