package com.qidongyinqing.www.designpattern.designpattern.factoryandconsumer;

import android.util.Log;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Logger;

public class ConsumerThread extends  Thread {

    private static final String TAG = "ConsumerThread";
    private LinkedBlockingQueue<String> queue;
    public ConsumerThread(LinkedBlockingQueue<String> queue) {
        this.queue= queue;
    }


    @Override
    public void run() {

            while (true){
                try {
                    String task = queue.take();
                    Log.e(TAG,"消费掉了"+task);
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                super.run();
            }

    }
}
