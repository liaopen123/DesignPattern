package com.qidongyinqing.www.designpattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.com.almostlover.multithread.future.MainFuture;

/**
 * java 多线程 执行Activity
 */
public class MultiThreadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_thread);

        MainFuture mainFuture = new MainFuture();
        mainFuture.doIt();
    }
}
