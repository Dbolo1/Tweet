package com.bolo1.tweet_app.bean;

import java.io.Serializable;
import java.util.ArrayList;

public  class News_Data implements Serializable {
    public String getPosterId() {
        return posterId;
    }

    public void setPosterId(String posterId) {
        this.posterId = posterId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPublishDateStr() {
        return publishDateStr;
    }

    public void setPublishDateStr(String publishDateStr) {
        this.publishDateStr = publishDateStr;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "News_Data{" +
                "posterId='" + posterId + '\'' +
                ", content='" + content + '\'' +
                ", tags='" + tags + '\'' +
                ", url='" + url + '\'' +
                ", publishDateStr='" + publishDateStr + '\'' +
                ", title='" + title + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", commentCount='" + commentCount + '\'' +
                ", imageUrls=" + imageUrls +
                ", id='" + id + '\'' +
                '}';
    }

    //  posterId string null posterId
//    content string 最新的剧情中,陆晨曦( 新闻内容
//                                       posterScreenName string 腾讯 发布者名称
//                                       tags string null tags
//                                       url string http://ent.qq.com/a/20170508/023354.htm 新闻链接
//                                       publishDateStr string 2017-05-08T03:46:00 发布时间（UTC时间
//                                       title string 白百何陷医患风波 《外科》靳东职业生涯遇危机 标题
//                                       publishDate number 1494215160 发布日期时间戳
//                                       commentCount string null 评论数
//                                       imageUrls string null 图片
//                                       id string c028fc8126658124bc8f21a13650d51b 新闻id
    public String posterId;
    public String content;
    public String tags;
    public String url;
    public String publishDateStr;
    public String title;
    public String publishDate;
    public String commentCount;

    public ArrayList<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(ArrayList<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public ArrayList<String> imageUrls;
    public String id;

}
