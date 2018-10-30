package com.bolo1.tweet_app.http;

import com.bolo1.tweet_app.bean.Joke;
import com.bolo1.tweet_app.bean.News;
import com.bolo1.tweet_app.bean.SubjectInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import rx.Observable;
import rx.Observer;

public interface Api {
    //  ?&rn=10&tag1=美女&tag2=全部&ftags=小清新&ie=utf8

    /**
     *      获得美女图片的api
     *
     * @param page
     * @param rn
     * @param tag1
     * @param tag2
     * @param ftags
     * @param ie
     * @return
     */
    @GET("channel/listjson")
    Call<SubjectInfo> getMeiNv(
            @Query("pn") int page, @Query("rn") int rn, @Query("tag1") String tag1, @Query("tag2") String tag2,
            @Query("ftags") String ftags, @Query("ie") String ie);

    /**
     *  获得笑话的api
     * @param maxResult
     * @param page
     * @param showapi_appid
     * @param showapi_sign
     * @return
     */
    @GET("/341-1")
   Call<Joke> getJoke(@Query("maxResult") int maxResult,
                                          @Query("page") int page,
                                          @Query("showapi_appid") String  showapi_appid, @Query("showapi_sign") String showapi_sign);

    @GET("news/qihoo")
    Call<News> getNews(@Query("kw") String kw,@Query("pageToken") int pageToken,@Query("site") String site,@Query("apikey") String apikey);


}



