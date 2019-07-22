package com.qidongyinqing.www.designpattern.designpattern.factoryandconsumer;

import android.util.Log;

import java.util.concurrent.LinkedBlockingQueue;

public class FactoryThread extends  Thread {
    private static final String TAG = "FactoryThread";
    public LinkedBlockingQueue<String> queue;
    public FactoryThread(LinkedBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {

            try {
                String task = "第"+i+"个task";
                queue.put(task);
                Log.e(TAG,"生产"+task);
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



        super.run();
    }
}
