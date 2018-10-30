package com.bolo1.tweet_app.ui.uitls;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by 菠萝 on 2018/5/24.
 */

public class ToastUtil {

    private  static Toast toast;
    public static void show(Context context, String text){
        if(toast==null){
              toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
          }else {
              toast.setText(text);
          }
        toast.show();
    }



}
