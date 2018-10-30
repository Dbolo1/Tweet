package com.bolo1.tweet_app.http;

import android.util.Log;

import com.bolo1.tweet_app.app.Tweet;
import com.bolo1.tweet_app.bean.PostFromService;
import com.bolo1.tweet_app.ui.uitls.ConstantValue;
import com.bolo1.tweet_app.ui.uitls.LogUtils;
import com.bolo1.tweet_app.ui.uitls.Sputil;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by 菠萝 on 2018/6/26.
 */
public class NetToService implements Runnable {

    //写一个接口  当获得数据从接口返回

    private Object object;

    public  NetToService(Object pfs, OnCallBackServiceData onCallBackServiceData) {
        this.onCallBackServiceData = onCallBackServiceData;
        this.object = pfs;

    }

    @Override
    public void run() {
// TODO Auto-generated method stub
        //  String connectURL = "http://1.bolo1273459.applinzi.com/twriitertest1.php";//修改url地址 此为新浪云地址
        // String connectURL = "http://175.9.236.24:81/twriitertest1.php";//本地服务器地址
        String connectURL = "http://175.9.237.97:81/TestProject1.php";//本地服务器地址
        //填入用户名密码和连接地址
        //getDataFromService(object, connectURL);
        if (object instanceof PostFromService) {
            PostFromService pfs = (PostFromService) object;
            switch (pfs.getType()){
                case NetWorkCode.NEWS:
                    connectURL =NetWorkCode.NEWS_URL + pfs.getCurrentPage() + NetWorkCode.NEWS_API_KEY;
                    break;
                case NetWorkCode.GET_VIDEO:
                    connectURL=NetWorkCode.GET_VIDEO_URL+pfs.getCurrentPage()+NetWorkCode.VIDEO_KEY;
                    break;
            }
            LogUtils.e("url===" + connectURL);
            DoGetService(object, connectURL);
        } else {
            getDataFromService(object, connectURL);
        }
    }

    //登入的方法，传入用户 密码 和连接地址

//    private Handler handler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            if (msg.what == 1) {
//                //   ToastUtil.show(getActivity(), "response" + (String) msg.obj);
//                Log.d("tag", "这是消息体----" + (String) msg.obj);
//                Gson gson = new Gson();
//
//                try {
//                    JSONObject jsonObject = new JSONObject(msg.obj.toString());
//                    JSONArray user = jsonObject.getJSONArray(pfs.getData_type());
//                    if (onCallBackServiceData != null) {
//                        onCallBackServiceData.onSucceed(user);
//                    }
//                    Log.d("tag", "消息体--这是第次---" + user.toString());
//                    //  String user2 = jsonObject.getString("user");
////                    ArrayList<Object> objects = new ArrayList<>();
////                    for (int j = 0; j < user.length(); j++) {
////                        User user1 = gson.fromJson(user.get(j).toString(), User.class);
////                        objects.add(user1);
////                    }
//                    //  Log.d("tag","消息体--这是第"+i+"次---"+user1);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    };


    private void getDataFromService(final PostFromService pfs, String connectUrl) {
        String result = null; //用来取得返回的String；
        boolean isLoginSucceed = false;
        OkHttpUtil instance = OkHttpUtil.getInstance();
        //  Log.d("tag", "本地输入的用户名信息" + userName + "userid+=" + user_id + "user_pass==" + password);
        try {
            Gson gson = new Gson();
            Log.d("tag", "需要传送的pfs数据===" + pfs.toString());
            String s = gson.toJson(pfs);
            //    Log.d("tag", "gosn转化的json数据====" + s);
            instance.doPost(connectUrl, s, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    if (call.isCanceled()) {
                        Log.d("tag", "关闭这次请求");
                        if (onCallBackServiceData != null) {
                            onCallBackServiceData.onFailure("解析出错了");
                        }
                    }
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    Log.d("tag", "返回状态码" + response.code());
                    if (response.isSuccessful()) {
                        JSONObject jsonObject = null;
                        try {
                            //   LogUtils.d("返回的数据"+response.body().string());
                            //   String tmp = response.body().string();
                            //  Log.e("tag", "返回" + tmp);
//                            JSONArray jsonArray1 = new JSONArray(tmp);
//                            for (int i = 0; i <jsonArray1.length(); i++) {
//                                JSONObject jo = jsonArray1.getJSONObject(i);
//                                LogUtils.d(jo.toString());
//                            }
                            String jar = response.body().string();
                            Log.d("tag", "返回---" + jar);
                            LogUtils.d("返回msg-2ss--" + jar);

                            String tmp = "";
                            JSONObject jo = new JSONObject(tmp);

//                            if (!jsonObject1.getString(pfs.getState()).equals(NetWorkCode.OK)) {
//                                tmp = "";
//                            } else {
//                                String string = jsonObject1.getString(pfs.getType());
//                                JSONArray jsonArray = new JSONArray(string);
//                                tmp = jsonArray.toString();
//                            }

                            LogUtils.d("final  tmp = " + tmp);
                            if (onCallBackServiceData != null) {
                                onCallBackServiceData.onSucceed(tmp);
                            }
                            //jsonObject = new JSONObject(response.body().string());
                            // JSONArray user = jsonObject.getJSONArray(pfs.getType());

                            //   Log.d("tag","消息体--这是第次---"+response.body().string());
                        } catch (JSONException e) {


                            e.printStackTrace();
                        }
                    }
                }
            });
        } catch (Exception e) {
            if (onCallBackServiceData != null) {
                onCallBackServiceData.onFailure("网络错误");
            }
            e.printStackTrace();
        }
    }


    private void getDataFromService(final Object pfs, String connectUrl) {
        OkHttpUtil instance = OkHttpUtil.getInstance();
        try {
            Gson gson = new Gson();
            Log.d("tag", "需要传送的pfs数据===" + pfs.toString());
            String s = gson.toJson(pfs);
            instance.doPost(connectUrl, s, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    if (call.isCanceled()) {
                        Log.d("tag", "关闭这次请求");
                        if (onCallBackServiceData != null) {
                            onCallBackServiceData.onFailure("解析出错了");
                        }
                    }
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    Log.d("tag", "返回状态码" + response.code());
                    if (response.isSuccessful()) {
                        JSONObject jsonObject = null;
                        try {
                            //   LogUtils.d("返回的数据"+response.body().string());
                            //   String tmp = response.body().string();
                            //  Log.e("tag", "返回" + tmp);
//                            JSONArray jsonArray1 = new JSONArray(tmp);
//                            for (int i = 0; i <jsonArray1.length(); i++) {
//                                JSONObject jo = jsonArray1.getJSONObject(i);
//                                LogUtils.d(jo.toString());
//                            }
                            String tmp = response.body().string();
                            Log.d("tag", "返回---" + tmp);
                            LogUtils.d("返回msg-2ss--" + tmp);
                            JSONObject jo = new JSONObject(tmp);
                            if (jo.getString("state").equals(NetWorkCode.OK)) {
                                // 获得数据成功
                                if (onCallBackServiceData != null) {
                                    onCallBackServiceData.onSucceed(tmp);
                                }
                            } else {
                                if (onCallBackServiceData != null) {
                                    onCallBackServiceData.onFailure(tmp);
                                }
                            }
//                            if (!jsonObject1.getString(pfs.getState()).equals(NetWorkCode.OK)) {
//                                tmp = "";
//                            } else {
//                                String string = jsonObject1.getString(pfs.getType());
//                                JSONArray jsonArray = new JSONArray(string);
//                                tmp = jsonArray.toString();
//                            }

                            //jsonObject = new JSONObject(response.body().string());
                            // JSONArray user = jsonObject.getJSONArray(pfs.getType());

                            //   Log.d("tag","消息体--这是第次---"+response.body().string());
                        } catch (JSONException e) {

                            e.printStackTrace();
                        }
                    }
                }
            });
        } catch (Exception e) {
            if (onCallBackServiceData != null) {
                onCallBackServiceData.onFailure("网络错误");
            }
            e.printStackTrace();
        }
    }


    public synchronized void DoGetService(Object object, String connectUrl) {
        LogUtils.e("msg--" + connectUrl);
        OkHttpUtil instance = OkHttpUtil.getInstance();
        instance.doGet(connectUrl, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if (call.isCanceled()) {
                    Log.d("tag", "关闭这次请求");
                    if (onCallBackServiceData != null) {
                        onCallBackServiceData.onFailure("解析出错了");
                    }
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String tmp = response.body().string();
                    // 获得数据成功
                    byte[] bytes = tmp.getBytes("utf-8");
                    String s = new String(bytes, "utf-8");
                    //写入缓存 主要是图片缓存

                    Sputil.putString(Tweet.getContext(),ConstantValue.CACHE_JSON,s);
                    Log.d("tag", "s=="+s);
                    if (onCallBackServiceData != null) {
                        onCallBackServiceData.onSucceed(s);
                    }

                } else {
                    if (onCallBackServiceData != null) {
                        onCallBackServiceData.onFailure("网络错误");
                    }
                }
            }
        });
    }


    private OnCallBackServiceData onCallBackServiceData;

    public interface OnCallBackServiceData {
        void onFailure(String s);

        void onSucceed(Object objects);

    }


}
