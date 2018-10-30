package com.bolo1.tweet_app.cache;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by 菠萝 on 2018/3/15.
 */

public class CacheManager {

    //wifi缓存的存储时间
    private static long wifi_cache_time = 60*1000*5; //5分钟
    //其他缓存的存储时间
    private static long other_cache_time = 60*1000*60; //1小时

    public static Serializable readObject(Context context, String file){
        if(!isExistDataCache(context,file))return false;

        FileInputStream fis=null;
        ObjectInputStream ois=null;
        try {
             fis = context.openFileInput(file);
             ois = new ObjectInputStream(fis);
            return (Serializable) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public static boolean saveObject(Context context, Serializable data, String file) {
        FileOutputStream fos =null;
        ObjectOutputStream oos=null;
        try {
             fos = context.openFileOutput(file, Context.MODE_PRIVATE);
             oos = new ObjectOutputStream(fos);
            oos.writeObject(data);
            oos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public  static  boolean isExistDataCache(Context context, String cacheFile){
        if(context==null){
            return false;
        }
        boolean exist  = false;
        File file = context.getFileStreamPath(cacheFile);
        if(file.exists()){
            exist=true;
        }
        return exist;
    }

//
//    public  static  boolean isCacheFailure(Context context,String cacheFile){
//        if(context==null){
//            return false;
//        }
//        File file = context.getFileStreamPath(cacheFile);
//        if(!file.exists()){
//            return false;
//        }
//        //判断当前网络是否为WiFi
//
//
//    }
//



}
