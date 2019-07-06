package cn.com.almostlover.multithread.multi_thread_mode1.guardde_suspension;

import java.util.LinkedList;

public class RequestQueue {

    private LinkedList queue = new LinkedList();

    public synchronized Request getRequest() {
        while (queue.size() == 0) {
            try {
                synchronized (Thread.currentThread()){
                    Thread.currentThread().wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return ((Request) queue.remove());
    }


    public synchronized void addRequest(Request request) {
        queue.add(request);
        notifyAll();
    }
}
