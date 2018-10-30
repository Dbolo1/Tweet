package com.bolo1.tweet_app.http;

/**
 * Created by 菠萝 on 2018/5/14.
 */

public class NetworkUrl {
    //获取总地址在拼接
    public static  final  String URL = "http://175.0.79.173:8080/";

    public static  final  String TweetFragmentURL =URL+"tweet/com.bolo1.tweet_app/tweet/tweet_news_";

    public static final String _JSON=".json";
    public static final String _TXT=".txt";


    public static final String CommentFragment="tweet/com.bolo1.tweet_app/comment/comment_video";

    public static  final  String JokeFragmentURL= URL+"tweet/com.bolo1.tweet_app/tweet/tweet_joke_";
}
