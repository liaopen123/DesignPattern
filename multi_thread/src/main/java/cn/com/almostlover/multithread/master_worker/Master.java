package cn.com.almostlover.multithread.master_worker;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Master {
    //任务队列
    protected Queue<Object> workQueue = new ConcurrentLinkedDeque<Object>();
    //worker队列
    protected Map<String, Thread> threadMap = new HashMap<String, Thread>();
    //任务队列
    protected Map<String, Object> resultMap = new ConcurrentHashMap<String, Object>();


    public Master(Worker worker, int countWorker) {
        worker.setWorkQueue(workQueue);
        worker.setResultMap(resultMap);

        for (int i = 0; i < countWorker; i++) {
            threadMap.put(Integer.toString(i), new Thread(worker, Integer.toString(i)));
        }
    }


    public void submit(Object job) {
        workQueue.add(job);
    }


    public Map<String, Object> getResultMap() {
        return resultMap;
    }

    public void execute() {
        for (Map.Entry<String, Thread> entry : threadMap.entrySet()) {
            entry.getValue().start();
        }
    }

    public boolean isCompete() {
        for (Map.Entry<String, Thread> entry : threadMap.entrySet()) {
            if (entry.getValue().getState() != Thread.State.TERMINATED) {
                return false;
            }

        }
        return true;
    }
}
