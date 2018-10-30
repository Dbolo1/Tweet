package com.bolo1.tweet_app.bean;

/**
 * Created by 菠萝 on 2018/7/22.
 */

public class ShortVideo {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    @Override
    public String toString() {
        return "ShortVideo{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", video_url='" + video_url + '\'' +
                ", video_load_image='" + video_load_image + '\'' +
                ", video_date='" + video_date + '\'' +
                ", video_like=" + video_like +
                ", video_comment=" + video_comment +
                '}';
    }

    public String getVideo_load_image() {
        return video_load_image;
    }

    public void setVideo_load_image(String video_load_image) {
        this.video_load_image = video_load_image;
    }

    public String getVideo_date() {
        return video_date;
    }

    public void setVideo_date(String video_date) {
        this.video_date = video_date;
    }

    public int getVideo_like() {
        return video_like;
    }

    public void setVideo_like(int video_like) {
        this.video_like = video_like;
    }

    public int getVideo_comment() {
        return video_comment;
    }

    public void setVideo_comment(int video_comment) {
        this.video_comment = video_comment;
    }

    private int  id;
    private int  user_id;
    private String    video_url;
    private String   video_load_image;
    private String         video_date;
    private int  video_like;
    private int  video_comment;



}
