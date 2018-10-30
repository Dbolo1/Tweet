package com.bolo1.tweet_app.http;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetNetApi {
    private GetNetApi(){}
    private static Api api=null;
    private static String tmpUrl;
    public static Api getApi(String baseUrl){
        if(api==null||!baseUrl.equals(tmpUrl)){
            synchronized (GetNetApi.class){
                if(api==null||!baseUrl.equals(tmpUrl)){
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(baseUrl)
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                    api = retrofit.create(Api.class);
                }
            }

        }
        tmpUrl=baseUrl;
        return api;
    }
}
