package com.bolo1.tweet_app.http;

/**
 * Created by 菠萝 on 2018/5/14.
 */

public class NetWorkCode {
    public static final int Get = 101;
    public static final int Post = 102;
    public static final int code = Get;
    /**
     * 获得数据
     */
    public static final String GET_JOKE_DATA = "get_joke_data";
    /**
     * 注册
     */
    public static final String REGISTER_USER = "register_user";
    /**
     * 登录
     */
    public static final String LOGIN_USER = "login_user";
    /**
     * 文章
     */
    public static final String NEWS_ARTICLE = "news_article";


    /**
     * 获取视频
     */
    public static final String GET_VIDEO = "video";


    public static final String OK = "OK";
    public static final String NEWS = "news";
    /**
     * 请求新闻api
     * 格式 http://api.avatardata.cn/GuoNeiNews/Query?key=f17afc58b06b4d75aa0e6ea1d515aa85&page=1&rows=10
     * http://api01.idataapi.cn:8000/news/qihoo?kw=%E7%99%BD&site=qq.com&1&apikey=DX0GY49Y2Bjg8h0MIS6MYOQzuet2hR0RAoqWg5Aj0NN2JtisyqUrLVJt96cor8Sz
     */
    public static final String NEWS_URL = "http://api01.idataapi.cn:8000/";
    public static final String NEWS_URL_kw = "头条";
    public static final String NEWS_URL_site = "qq.com";
    public static final String NEWS_API_KEY = "DX0GY49Y2Bjg8h0MIS6MYOQzuet2hR0RAoqWg5Aj0NN2JtisyqUrLVJt96cor8Sz";
////---------
    /**
     * 视频api接口 需要填写pageToken页数
     */
    public static final String GET_VIDEO_URL = "http://api01.idataapi.cn:8000/video/miaopai?kw=%E6%90%9E%E7%AC%91&pageToken=";
    public static final String VIDEO_KEY = "&apikey=DX0GY49Y2Bjg8h0MIS6MYOQzuet2hR0RAoqWg5Aj0NN2JtisyqUrLVJt96cor8Sz";
    /**
     * 美女图片的api----http://image.baidu.com/channel/listjson?pn=1&rn=10&tag1=美女&tag2=全部&ftags=小清新&ie=utf8
     */
    public static final String GET_MEINV = "http://image.baidu.com/";
    public static final String GET_MEINV_ARG = "";
    /**
     * 笑话的api
     */
    public static final String GET_JOKE = "https://route.showapi.com/";
    public static final String JOKE_API = "78401";
    public static final String JOKE_API_SIGN = "a1e746b4389e4345ae263192f79acccd";


}
