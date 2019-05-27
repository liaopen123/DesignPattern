package cn.com.almostlover.multithread.guardde_suspension.client;

import cn.com.almostlover.multithread.guardde_suspension.Request;
import cn.com.almostlover.multithread.guardde_suspension.RequestQueue;

public class ClientThread extends Thread {

    private RequestQueue requestQueue;

    public ClientThread(RequestQueue requestQueue, String name) {
        super(name);
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Request request = new Request("RequestId" + i + "Thread_Name:" + Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getName() + "request" + request);
            requestQueue.addRequest(request);

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ClientThread Name is" + Thread.currentThread().getName());
        }
        System.out.println(Thread.currentThread().getName() + "request end");

    }
}
