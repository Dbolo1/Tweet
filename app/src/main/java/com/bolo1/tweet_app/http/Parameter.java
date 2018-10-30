package com.bolo1.tweet_app.http;

import android.content.Context;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 菠萝 on 2018/5/14.
 */

public class Parameter {

    private final static String DATA_FORMAT_JSON = "JSON";

    private final static String ENCRYPT_TYPE_DES = "001";

    /**
     * 数据结构类型（json、xml等等）
     */
    public String format;
    /**
     * 加密类型
     * 001:Des加密
     */
    public String encryptType;
    /**
     * 是否加密
     * 0:不加密 1:加密
     */
    public String isEncrypt;

    /**
     * 公共参数
     */
    private HashMap<String, String> head;

    private Object data;

    /**
     * 默认构造函数,初始化时默认:
     * <br>format为FORMAT_JSON
     * <br>encryptType为ENCRYPT_TYPE_DES
     * <br>isEncrypt为true
     * <br>并且在构造方法中设置公共参数
     */
    public Parameter(Context context) {
        head = new HashMap<>();
        data = new HashMap<String, String>();
        this.format = DATA_FORMAT_JSON;
        this.encryptType = ENCRYPT_TYPE_DES;
//        this.isEncrypt = String.valueOf(BaseConfig.YES);
//        head.put("phoneName", DeviceInfo.getInstance().model);
//        head.put("phoneVersion", DeviceInfo.getInstance().osVersion);
//        head.put("imei", DeviceInfo.getInstance().imei);
//        head.put("softVersion", AppUtil.getAppVersionName());
//        head.put("imsi", DeviceInfo.getInstance().simImsi);
//        head.put("loginName", ClientApplication.getInstance().getUserInfo() == null ? "" : ClientApplication.getInstance().getUserInfo().getLoginName());
//        head.put("ownship", DeviceInfo.getInstance().simCarrier);
//        head.put("sk", DeviceInfo.getInstance().imei);

    }

    public void setHeadLoginName(String loginName){
        head.put("loginName", loginName);
    }

    /**
     * 生成公共参数
     *
     * @return 按照指定的数据结构类型返回相应的公共参数字符串表述
     */
    public String getHeadString() {
        if (TextUtils.isEmpty(format)) {
            return null;
        }
        String result = null;
        if (format.equals(DATA_FORMAT_JSON)) {
            try {
                JSONObject main = new JSONObject();
                for (Map.Entry<String, String> entry : head.entrySet()) {
                    main.put(entry.getKey(), entry.getValue());
                }
                result = main.toString().trim();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


    public void setData(Object data) {
        this.data = data;
    }


    /**
     * 生成业务参数
     *
     * @return 按照指定的数据结构类型返回相应的业务参数字符串表述
     */
    public String getDataString() {
        if (data == null) {
            return null;
        }
        String result = null;
        Gson gson = null;
        if (data instanceof Map) {
            gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().enableComplexMapKeySerialization().create();
        } else {
            gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation() // 不导出实体中没有用@Expose注解的属性
//                    .serializeNulls()// 将取值为null的字段也输出到json字符串中
                    .setDateFormat("yyyy-MM-dd HH:mm:ss")// 时间转化为特定格式
                    .setPrettyPrinting() // 对json结果格式化.
                    .create();
        }
        result = gson.toJson(data);

        return result;
    }

    @Override
    public String toString() {
        return "format=" + format + "&isKey=" + isEncrypt + "&keyType=" + encryptType + "&head=" + getHeadString() + "&data=" + getDataString();
    }


}
