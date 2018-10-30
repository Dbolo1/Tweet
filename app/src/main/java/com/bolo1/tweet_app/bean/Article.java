package com.bolo1.tweet_app.bean;

/**
 * Created by 菠萝 on 2018/6/25.
 */

public class Article {
    private int article_id;
    private String user_id;
    private String article_des;
    private int article_type;
    private String article_like;
    private String article_dislike;
    private String article_comments;
    private String article_image_url;
    private String article_video_url;

    public String getArticle_image_url() {
        return article_image_url;
    }

    public void setArticle_image_url(String article_image_url) {
        this.article_image_url = article_image_url;
    }

    public String getArticle_video_url() {
        return article_video_url;
    }

    public void setArticle_video_url(String article_video_url) {
        this.article_video_url = article_video_url;
    }

    private String article_title;
    private String made_date;

    @Override
    public String toString() {
        return "Article{" +
                "article_id=" + article_id +
                ", user_id=" + user_id +
                ", article_des='" + article_des + '\'' +
                ", article_type=" + article_type +
                ", article_like='" + article_like + '\'' +
                ", article_dislike='" + article_dislike + '\'' +
                ", article_comments='" + article_comments + '\'' +
                ", article_title='" + article_title + '\'' +
                ", made_date='" + made_date + '\'' +
                ", article_image_url='" + article_image_url + '\'' +
                ", article_video_url='" + article_video_url + '\'' +
                '}';
    }

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getArticle_des() {
        return article_des;
    }

    public void setArticle_des(String article_des) {
        this.article_des = article_des;
    }

    public int getArticle_type() {
        return article_type;
    }

    public void setArticle_type(int article_type) {
        this.article_type = article_type;
    }

    public String getArticle_like() {
        return article_like;
    }

    public void setArticle_like(String article_like) {
        this.article_like = article_like;
    }

    public String getArticle_dislike() {
        return article_dislike;
    }

    public void setArticle_dislike(String article_dislike) {
        this.article_dislike = article_dislike;
    }

    public String getArticle_comments() {
        return article_comments;
    }

    public void setArticle_comments(String article_comments) {
        this.article_comments = article_comments;
    }



    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public String getMade_date() {
        return made_date;
    }

    
    public void setMade_date(String article_date) {
        this.made_date = made_date;
    }
}
