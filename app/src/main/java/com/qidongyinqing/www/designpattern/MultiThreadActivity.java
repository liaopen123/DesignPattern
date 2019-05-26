package com.qidongyinqing.www.designpattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import cn.com.almostlover.multithread.future.MainFuture;
import cn.com.almostlover.multithread.master_worker.MainMasterWorker;

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

        new MainMasterWorker().doIt();
    }
}
