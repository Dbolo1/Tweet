package com.bolo1.tweet_app.ui.uitls;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class BeanToJson {

    public static  void create(Object object){
        try {
            JSONObject jsonObject = new JSONObject(object.toString());
            Log.e("tag","测试json的数量"+jsonObject);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
