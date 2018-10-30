package com.bolo1.tweet_app.app;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;

import com.bolo1.tweet_app.ui.uitls.ToastUtil;


/**
 * Created by 菠萝 on 2017/11/17.
 */

public class Tweet extends  Application{
    private static Context context;
//    private static Handler handler;
   private static int mainThreadId;
////    MultiDexApplication

    @Override
    public void onCreate() {
        super.onCreate();
//        xUtil3.
  //      x.Ext.init(this);
        // 设置是否输出debug
     //   x.Ext.setDebug(true);
        context = getApplicationContext();
//        handler = new Handler();
       mainThreadId = Process.myTid();
    }

    public static Context getContext() {
        return context;
    }

   public static Handler getHandler() {
        return handler;
    }

    private static Handler handler = new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            ToastUtil.show(context,msg.obj.toString());
        }
    };
    public static int getMainThreadId() {
        return mainThreadId;
    }

}
