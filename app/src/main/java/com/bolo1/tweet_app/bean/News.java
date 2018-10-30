package com.bolo1.tweet_app.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by 菠萝 on 2018/5/14.
 */

public class News implements Serializable {
    @Override
    public String toString() {
        return "News{" +
                "hasNext=" + hasNext +
                ", retcode='" + retcode + '\'' +
                ", appCode='" + appCode + '\'' +
                ", dataType='" + dataType + '\'' +
                ", pageToken='" + pageToken + '\'' +
                ", data=" + data +
                '}';
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public String getRetcode() {
        return retcode;
    }

    public void setRetcode(String retcode) {
        this.retcode = retcode;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getPageToken() {
        return pageToken;
    }

    public void setPageToken(String pageToken) {
        this.pageToken = pageToken;
    }

    public ArrayList<News_Data> getData() {
        return data;
    }

    public void setData(ArrayList<News_Data> data) {
        this.data = data;
    }

    ////    参数名 类型 示例值 描述
//    hasNext boolean true 是否有下一页
//    retcode string 000000 返回的状态码
//    appCode string qihoo 本次查询的api名
//    dataType string news 本次查询的api类型
//    pageToken string 2 翻页值\
    public boolean hasNext;
    public String retcode;
    public String appCode;
    public String dataType;
    public String pageToken;
    public ArrayList<News_Data>  data;


//-
//    data array [...] 返回的数据
//    posterId string null posterId
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






}
