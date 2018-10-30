package com.bolo1.tweet_app.ui.uitls;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Process;
import android.view.View;
import android.widget.ImageView;

import com.bolo1.tweet_app.R;
import com.bolo1.tweet_app.app.Tweet;

import org.xutils.image.ImageOptions;

import static com.bolo1.tweet_app.app.Tweet.getHandler;


/**
 * Created by 菠萝 on 2017/10/16.
 */

public class UIUtils {
    private static ImageOptions imageOptions;

    public static Context getContext(){
       return Tweet.getContext();
   }
//    public static Handler getHandler(){
//        return Tweet.getHandler();
//    }
    public static int getMainThreadId(){
        return Tweet.getMainThreadId();
    }
    // ////////////////////获得资源文件/////////////////////////


    public static String getString(int id){
        return getContext().getResources().getString(id);
    }
    public static  String[] getStringArray(int id){
        return getContext().getResources().getStringArray(id);
    }
    public static Drawable getDrawable(int id){

        return getContext().getResources().getDrawable(id);
    }
    public static int getColor(int id){
        return getContext().getResources().getColor(id);
    }
    //根据id选择颜色选择器
    public static ColorStateList getColorStateList(int id) {
        return getContext().getResources().getColorStateList(id);
    }
    public static int getDemen(int id){
        return getContext().getResources().getDimensionPixelSize(id);//返回像素大小
    }

    // ////////////////////pd与px的转换////////////////////////////
    public static int dip2px(int dip){
        float density=getContext().getResources().getDisplayMetrics().density;
        return (int) (density*dip+0.5);
    }

    public static float px2dip(int px){
        float density=getContext().getResources().getDisplayMetrics().density;
        return  (density/px);
    }


    public static ImageOptions display() {

        if (imageOptions == null) {
            imageOptions = new ImageOptions.Builder()
                    .setIgnoreGif(false)//是否忽略gif图。false表示不忽略。不写这句，默认是true
                    .setImageScaleType(ImageView.ScaleType.CENTER_CROP)
                    .setFailureDrawableId(R.mipmap.ic_launcher)
                    .build();
        }
        return imageOptions;
//        for (int i = 0; i < ll_parent.getChildCount(); i++) {
//            x.image().bind(ll_parent.getChildAt(i),news.getImageUrl1());
//        }
    }

    // /////////////////////加载布局文件////////////////////////
    public static View getinflate(int  id){
        return View.inflate(getContext(),id,null);
    }

    // ////////////////判断当前线程是否为主线程////////////////////////
//    public static boolean isRunOnUiThread(){
//        //获得当前线程的id
//        int myTid= Process.myTid();
//        //对当前id进行判断
//        if(myTid==getMainThreadId()){
//            return true;
//        }else{
//            return false;
//        }
//    }
//
//    //运行在主线程
//    public static void runOnUiThread(Runnable r){
//        //判断当前线程
//        if(isRunOnUiThread()){
//            //如果是主线程则运行
//            r.run();
//        }else{
//            //将线程post给主线程
//            getHandler().post(r);
//        }
//    }

    // ////////////////判断当前线程是否为主线程////////////////////////
    public static boolean isRunOnUiThread(){
        //获得当前线程的id
        int myTid=Process.myTid();
        //对当前id进行判断
        if(myTid==getMainThreadId()){
            return true;
        }else{
            return false;
        }
    }

    //运行在主线程
    public static void runOnUiThread(Runnable r){
        //判断当前线程
        if(isRunOnUiThread()){
            //如果是主线程则运行
            r.run();
        }else{
            //将线程post给主线程
            getHandler().post(r);
        }
    }

}
