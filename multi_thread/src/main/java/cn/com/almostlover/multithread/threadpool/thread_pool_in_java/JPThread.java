package cn.com.almostlover.multithread.threadpool.thread_pool_in_java;

import java.util.logging.Logger;

public class JPThread extends Thread {

    private final JThreadPool pool;
    private Runnable target;
    private boolean isShutdown = false;
    private boolean isIdel = false;

    public JPThread(Runnable target, String name, JThreadPool pool) {
        super(name);
        this.pool = pool;
        this.target = target;
    }

    public Runnable getTarget() {
        return target;
    }

    public boolean isIdel() {
        return isIdel;
    }

    @Override
    public void run() {
        while (!isShutdown) {
            isIdel = false;
            if (target != null) {
                target.run();
                System.out.println("target:"+target.toString());
            }
            //任务完成，不关闭线程，而是重新放入线程池中。
            isIdel = true;
            try {
                pool.rePool(this);
                synchronized (this) {
                    wait();
                }
            } catch (Exception e) {

            }
            isIdel = false;
        }
    }


    public synchronized void setTarget(Runnable newTarget) {
        target = newTarget;
        notifyAll();
    }

    public synchronized void shutdown() {
        isShutdown = true;
        notifyAll();
    }
}
