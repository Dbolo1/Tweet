package com.bolo1.tweet_app.http.protocol;



import com.bolo1.tweet_app.bean.SubjectInfo;
import com.bolo1.tweet_app.ui.uitls.LogUtils;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 菠萝 on 2017/10/27.
 */

public class SubjectProtocol extends BaseProtocol<ArrayList<SubjectInfo.DataBean>> {


   // private ArrayList<SubjectInfo.DataBean> list;
    private ArrayList<SubjectInfo.DataBean> data;

    @Override
    public String getParam() {
        return "";
    }

    @Override
    public String getKey() {
        return "subject";
    }

    @Override
    public ArrayList<SubjectInfo.DataBean> parseData(String result) {
        try {
            JSONArray ja = new JSONArray(result);
          // list = new ArrayList<SubjectInfo.DataBean>();
//            for (int i=0;i<ja.length();i++){
//                JSONObject jo=ja.getJSONObject(i);
//                SubjectInfo info=new SubjectInfo();
//
//                info.image_url=jo.getString("image_url");
//                info.desc=jo.getString("desc");
//
//                list.add(info);
//            }
            Gson gson = new Gson();
            SubjectInfo subjectInfo = gson.fromJson(result, SubjectInfo.class);
            data = (ArrayList<SubjectInfo.DataBean>) subjectInfo.getData();

        } catch (JSONException e) {
            e.printStackTrace();
        }
        LogUtils.d("主题解析的数据"+data);
        return  data;
    }
}
