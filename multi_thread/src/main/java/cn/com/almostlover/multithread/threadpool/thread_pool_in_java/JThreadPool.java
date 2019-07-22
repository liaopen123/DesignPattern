package cn.com.almostlover.multithread.threadpool.thread_pool_in_java;

import java.util.List;
import java.util.Vector;


public class JThreadPool {


    private static JThreadPool mInstance;
    private List<JPThread> idleThreads;
    //已有线程总数
    private int threadCounter;
    private boolean isShutdown = false;

    private JThreadPool() {
        this.idleThreads = new Vector<>(5);
        threadCounter = 0;
    }
    public  static  JThreadPool getInstance(){
        if (mInstance == null) {
            mInstance = new JThreadPool();
        }

        return mInstance;
    }
    public int getCreatedThreadsCount(){
        return threadCounter;
    }


    public void  rePool(JPThread repoolingThread){
        if(!isShutdown){
            idleThreads.add(repoolingThread);
        }else{
            repoolingThread.shutdown();
        }
    }

    public void start(Runnable target){
        JPThread thread = null;
        if (idleThreads.size()>0) {
            int lastIndex = idleThreads.size() - 1;
           thread= idleThreads.get(lastIndex);
           idleThreads.remove(lastIndex);
           thread.setTarget(target);

        }else{
            threadCounter++;
            thread = new JPThread(target,"JPThead #"+threadCounter,this);
            thread.start();
        }


    }

    public void shutdown(){
        isShutdown =true;
        for (int i = 0; i < idleThreads.size(); i++) {
            JPThread pThread = idleThreads.get(i);
            pThread.shutdown();
        }
    }
}
