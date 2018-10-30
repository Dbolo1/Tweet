//package com.bolo1.tweet_app.http;
//
//import android.os.Handler;
//import android.os.Message;
//import android.text.TextUtils;
//import android.util.Log;
//
//import com.bolo1.tweet_app.ui.uitls.NetworkConfig;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//import okhttp3.Call;
//import okhttp3.Callback;
//import okhttp3.Cookie;
//import okhttp3.CookieJar;
//import okhttp3.FormBody;
//import okhttp3.HttpUrl;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.RequestBody;
//import okhttp3.Response;
//
///**
// * Created by 菠萝 on 2018/5/14.
// */
//
//public class NetworkUtil {
//
//
//        private final String TAG = getClass().getSimpleName() + "-->>";
//
//        /**
//         * 当没有明确的对象作为锁，只是想让一段代码同步时，可以创建一个特殊的instance变量（它得是一个对象）来充当锁
//         * 零长度的byte数组对象创建起来将比任何对象都经济――查看编译后的字节码：
//         * 生成零长度的byte[]对象只需3条操作码，而Object lock = new Object()则需要7行操作码。
//         */
//        private static final byte[] LOCK = new byte[0];
//        private static NetworkUtil mInstance;
//        private OkHttpClient mOkHttpClient;
//
//        private final static int WHAT_SUCCESS = 1;
//        private final static int WHAT_FAIL = 2;
//        private final static int WHAT_PROGRESS = 3;
//
//        public static NetworkUtil getInstance() {
//            if (mInstance == null) {
//                synchronized (LOCK) {
//                    if (mInstance == null) {
//                        mInstance = new NetworkUtil();
//                    }
//                }
//            }
//            return mInstance;
//        }
//
//        /**
//         * 构造方法
//         * 实现 mOkHttpClient
//         */
//        private NetworkUtil() {
//            OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
//
//            clientBuilder.cookieJar(new CookieJar() {
//                private String JSESESSION_VALUE = null;
//                private ArrayList<Cookie> cookies = new ArrayList<>();
//
//                @Override
//                public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
//
//                    if(TextUtils.isEmpty(JSESESSION_VALUE)){
//                        for(Cookie cookie:cookies){
////                        Log.d(TAG, url + "\nname = " + cookie.name() + "\nvalue = " + cookie.value());
//                            if(cookie.name().equals("JSESSIONID")){
//                                JSESESSION_VALUE = cookie.value();
//                                this.cookies.clear();
//                                this.cookies.add(cookie);
//                                break;
//                            }
//                        }
//                    }
//
////                Log.d(TAG, "saveFromResponse:" + url.host());
//                    for(Cookie cookie:cookies){
////                    Log.d(TAG, url + "\nname = " + cookie.name() + "\nvalue = " + cookie.value());
//                    }
//                }
//
//                @Override
//                public List<Cookie> loadForRequest(HttpUrl url) {
//                    if(cookies != null && cookies.size() > 0){
//                        for(Cookie cookie:cookies){
////                        Log.d(TAG, url + "\nname = " + cookie.name() + "\nvalue = " + cookie.value());
//                        }
//                    }
//                    return cookies;
//                }
//            });
//            clientBuilder.readTimeout(NetworkConfig.NETWORK_READ_TIMEOUT, TimeUnit.SECONDS);
//            clientBuilder.connectTimeout(NetworkConfig.NETWORK_CONNECT_TIMEOUT, TimeUnit.SECONDS);
//            clientBuilder.writeTimeout(NetworkConfig.NETWORK_WRITE_TIMEOUT, TimeUnit.SECONDS);
//            mOkHttpClient = clientBuilder.build();
//        }
//
//
//        /**
//         * 按照接口名称请求数据
//         * @param method
//         * @param parameter
//         * @param callBack
//         */
//        public void post(final String method, Parameter parameter, final NetworkCallBack callBack){
//            postFullUrl(NetworkConfig.BASE_ACTION_URL + method, parameter, callBack);
//        }
//
//
//
//        /**
//         * post方法提交表单信息
//         * @param fullUrl 接口地址
//         * @param parameter 请求参数
//         * @param callBack 自定义的回调接口
//         */
//        public void postFullUrl(final String fullUrl, Parameter parameter, final NetworkCallBack callBack){
//
//            final Handler handler = new Handler(){
//                @Override
//                public void handleMessage(Message msg) {
//                    super.handleMessage(msg);
//
//                    switch (msg.what) {
//                        case WHAT_SUCCESS:
//                            String result = (String) msg.obj;
//                            callBack.onSuccess(result);
//                            break;
//                        case WHAT_FAIL:
//                            NetworkStatus status = (NetworkStatus) msg.obj;
//                            callBack.onFail(status);
//                            break;
//                    }
//                }
//            };
//
//
//            FormBody.Builder builder = new FormBody.Builder();
//
//            String format = parameter.format;
//            String isKey = parameter.isEncrypt;
//            String keyType = parameter.encryptType;
//            String head = parameter.getHeadString();
//            String data = parameter.getDataString();
//
//            try { // 将传过来的参数字符串加密
//                head = Des3.encode(head);
//                data = Des3.encode(data);
//            } catch (Exception e1) {
//                throw new RuntimeException(e1);
//            }
//
//            builder.add("format", format);
//            builder.add("isKey", isKey);
//            builder.add("keyType", keyType);
//            builder.add("head", head);
//            builder.add("data", data);
//
//
//            //请求体
//            RequestBody body = builder.build();
//
//            //构建请求对象
//            Request request = new Request.Builder()
//                    .url(fullUrl)
//                    .post(body)
//                    .build();
//
//            callBack.onStart();
//
//            //发起请求
//            Call call = mOkHttpClient.newCall(request);
//            call.enqueue(new Callback() {
//                @Override
//                public void onFailure(Call call, IOException e) {
//                    handler.sendMessage(handler.obtainMessage(WHAT_FAIL, NetworkStatus.STATUS_FAIL_IO_EXCEPTION));
//                }
//
//                @Override
//                public void onResponse(Call call, Response response) throws IOException {
//
//                    String result = response.body().string();
//
//                    if(TextUtils.isEmpty(result)){
//                        handler.sendMessage(handler.obtainMessage(WHAT_FAIL, NetworkStatus.STATUS_FAIL_SERVICE_ERROR));
//                        return;
//                    }
//
//                    try {
//                        String decodeResult = Des3.decode(result);
//                        Log.d(TAG, "response:" + fullUrl + "\n" + decodeResult);
//
//                        Gson gson = new GsonBuilder().create();
//                        BaseResponseEntity baseResponse = gson.fromJson(decodeResult, BaseResponseEntity.class);
//
//                        switch (NetworkStatus.getNetworkStatusByCode(baseResponse.getCode())){
//                            case STATUS_SUCCESS:
//                                handler.sendMessage(handler.obtainMessage(WHAT_SUCCESS, decodeResult));
//                                break;
//                            case STATUS_FAIL_PARAMS_ERROR:
//                                handler.sendMessage(handler.obtainMessage(WHAT_FAIL, NetworkStatus.STATUS_FAIL_PARAMS_ERROR.setMessage(baseResponse.getMessage()).setResponseStr(decodeResult)));
//                                break;
//                            case STATUS_FAIL_SERVICE_ERROR:
//                                handler.sendMessage(handler.obtainMessage(WHAT_FAIL, NetworkStatus.STATUS_FAIL_SERVICE_ERROR.setMessage(baseResponse.getMessage()).setResponseStr(decodeResult)));
//                                break;
//                            case STATUS_FAIL_SESSION_OUT:
//                                handler.sendMessage(handler.obtainMessage(WHAT_FAIL, NetworkStatus.STATUS_FAIL_SESSION_OUT.setMessage(baseResponse.getMessage()).setResponseStr(decodeResult)));
//                                break;
//                            default:
//                                handler.sendMessage(handler.obtainMessage(WHAT_FAIL, NetworkStatus.STATUS_FAIL_SERVICE_ERROR.setCode(baseResponse.getCode()).setMessage(baseResponse.getMessage()).setResponseStr(decodeResult)));
//                                break;
//                        }
//                    }catch (Exception e){
//                        e.printStackTrace();
//                        handler.sendMessage(handler.obtainMessage(WHAT_FAIL, NetworkStatus.STATUS_FAIL_PARSING_ERROR));
//                    }
//                }
//            });
//        }
//
//
//
//
//}
