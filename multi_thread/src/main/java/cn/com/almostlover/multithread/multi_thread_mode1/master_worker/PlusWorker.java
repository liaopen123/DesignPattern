package cn.com.almostlover.multithread.multi_thread_mode1.master_worker;

public class PlusWorker extends Worker {
    @Override
    public Object handle(Object input) {
        Integer input1 = (Integer) input;
        return  input1;
    }
}
