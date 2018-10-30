package com.bolo1.tweet_app.http;

/**
 * Created by 菠萝 on 2018/5/14.
 */

public abstract class NetworkCallBack {

        public abstract void onStart();

        /**
         * 网络请求或者文件上传下载成功的结果回调
         *
         * @param result 保存网络请求返回数据
         */
        public abstract void onSuccess(String result);


        /**
         * 网络请求或者文件上传下载失败的回调方法
         *
         * @param status 接口返回状态信息
         */
        public abstract void onFail(NetworkStatus status);


        /**
         * 上传或者下载文件的时候进度返回
         *
         * @param current  当前字节数
         * @param total    总字节数
         * @param progress 进度百分比
         */
        public void onProgress(long current, long total, int progress) {

        }

        public void onLoadPictureSuccess(byte[] bytes) {


    }
}
