package cn.com.almostlover.multithread.guardde_suspension.server;

import cn.com.almostlover.multithread.guardde_suspension.Request;
import cn.com.almostlover.multithread.guardde_suspension.RequestQueue;

public class ServerThread extends Thread {

    private RequestQueue requestQueue;

    public ServerThread(RequestQueue requestQueue, String name) {
        super(name);
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {
        while (true) {
            Request request = requestQueue.getRequest();
            try {
                synchronized (Thread.currentThread()){
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "handles" + request);
        }
    }
}
