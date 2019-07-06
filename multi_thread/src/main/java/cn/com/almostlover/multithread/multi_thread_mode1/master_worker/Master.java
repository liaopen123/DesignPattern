package cn.com.almostlover.multithread.multi_thread_mode1.master_worker;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Master {
    //任务队列
    protected Queue<Object> taskQueue = new ConcurrentLinkedDeque<Object>();
    //worker队列
    protected Map<String, Thread> wokerMap = new HashMap<String, Thread>();
    //任务队列
    protected Map<String, Object> resultMap = new ConcurrentHashMap<String, Object>();


    public Master(Worker worker, int countWorker) {
        worker.setWorkQueue(taskQueue);
        worker.setResultMap(resultMap);

        for (int i = 0; i < countWorker; i++) {
            //一共5个thread
            wokerMap.put(Integer.toString(i), new Thread(worker, Integer.toString(i)));
        }
    }

    // call 100 times
    public void submit(Object job) {
        taskQueue.add(job);
    }


    public Map<String, Object> getResultMap() {
        return resultMap;
    }

    public void execute() {
        for (Map.Entry<String, Thread> entry : wokerMap.entrySet()) {
            entry.getValue().start();
        }
    }

    public boolean isCompete() {
        for (Map.Entry<String, Thread> entry : wokerMap.entrySet()) {
            if (entry.getValue().getState() != Thread.State.TERMINATED) {
                return false;
            }

        }
        return true;
    }
}
