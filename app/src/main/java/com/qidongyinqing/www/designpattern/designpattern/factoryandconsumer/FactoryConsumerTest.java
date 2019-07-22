package com.qidongyinqing.www.designpattern.designpattern.factoryandconsumer;

import java.util.concurrent.LinkedBlockingQueue;

public class FactoryConsumerTest {

    public  static void  test(){
        LinkedBlockingQueue<String> queque = new LinkedBlockingQueue<>(100);
        new FactoryThread(queque).start();
        new ConsumerThread(queque).start();
    }


}
