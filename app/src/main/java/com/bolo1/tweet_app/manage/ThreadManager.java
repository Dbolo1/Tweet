package com.bolo1.tweet_app.manage;



import com.bolo1.tweet_app.ui.uitls.LogUtils;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by 菠萝 on 2017/11/3.
 */

public  class ThreadManager {

    public static ThreadPool mThreadPool;

    //获取单例线程对象
    public static ThreadPool getThreadPool() {
        if (mThreadPool == null) {
            synchronized (ThreadManager.class) {
                if (mThreadPool == null) {
                    //获取cpu的核心线程数量
//                    int cpuNum = Runtime.getRuntime().availableProcessors();
//                    int threadNum = cpuNum * 2 + 1;
                    int threadNum= 10;
                //    LogUtils.d("获取的cpu数量==================" + cpuNum + "获取的线程数量============" + threadNum);
                    mThreadPool = new ThreadPool(threadNum, threadNum, 1L);
                }
            }
        }
        return mThreadPool;
    }


    public  static class ThreadPool {
        private int corePoolSize;//核心线程大小
        private int maximumPoolSize;//最大线程数
        private long keepAliveTime;//休息时间
        private ThreadPoolExecutor mExecutor;

        public ThreadPool(int cpuNum, int threadNum1, long AliveTime) {
            this.corePoolSize = cpuNum;
            this.maximumPoolSize = threadNum1;
            this.keepAliveTime = AliveTime;
        }

        /**
         *
         * @param runnable 创建线程池并加入线程
         */
        public void execute(Runnable runnable) {
            if (runnable == null) {
                return;
            }
            if (mExecutor == null) {

                mExecutor = new ThreadPoolExecutor(corePoolSize,
                        maximumPoolSize,
                        keepAliveTime,
                        TimeUnit.MINUTES,
                        new LinkedBlockingQueue<Runnable>(),
                        Executors.defaultThreadFactory(),
                        new ThreadPoolExecutor.AbortPolicy()) {
                };

                LogUtils.d("获取的cpu数量==================" + corePoolSize + "获取的线程数量============" + maximumPoolSize);
            }
            mExecutor.execute(runnable);
        }

        /**
         *
         * @param runnable 需要从线程池中移除的线程
         */
        public void cancel(Runnable runnable) {
            if(runnable!=null){
                mExecutor.getQueue().remove(runnable);
            }
        }
    }
}
