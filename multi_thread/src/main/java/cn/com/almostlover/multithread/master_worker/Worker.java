package cn.com.almostlover.multithread.master_worker;

import java.util.Map;
import java.util.Queue;

class Worker implements Runnable {
    //任务队列  用于取得子任务
    protected Queue<Object> workQueue;
    //子任务处理结果集
    protected Map<String, Object> resultMap;

    public void setWorkQueue(Queue<Object> workQueue) {
        this.workQueue = workQueue;
    }

    public void setResultMap(Map<String, Object> resultMap) {
        this.resultMap = resultMap;
    }

    @Override
    public void run() {

        while (true) {
            Object input = workQueue.poll();
            if (input == null) break;
            Object result = handle(input);

            //将处理结果写入结果集
            resultMap.put(Integer.toString(input.hashCode()), result);
        }


    }

    /**
     * 子任务具体实现的业务逻辑
     *
     * @param input
     * @return
     */
    public Object handle(Object input) {
        return input;
    }


}
