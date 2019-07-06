package com.qidongyinqing.www.designpattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import cn.com.almostlover.multithread.multi_thread_mode1.consumer_producer.MainConsumerProducer;
import cn.com.almostlover.multithread.threadpool.MyThread;
import cn.com.almostlover.multithread.threadpool.PThread;
import cn.com.almostlover.multithread.threadpool.ThreadPool;
import cn.com.almostlover.multithread.threadpool.thread_pool_in_java.JThreadPool;

/**
 * java 多线程 执行Activity
 */
public class MultiThreadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_thread);
//
//                MainFuture mainFuture = new MainFuture();
////                mainFuture.doIt();
//                mainFuture.doWithJdk();

//        new MainMasterWorker().doIt();
//        new MainGuardedSuspension().doIt();
//        new MainConsumerProducer().doIt();
        ExecutorService exe = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            JThreadPool.getInstance().start(new MyThread("testThreadPool"+ i));
//        exe.execute(new MyThread("testJDKThreadPool"+i));
        }


    }

}
