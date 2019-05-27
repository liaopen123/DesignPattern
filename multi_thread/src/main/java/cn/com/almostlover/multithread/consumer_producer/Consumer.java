package cn.com.almostlover.multithread.consumer_producer;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private BlockingQueue<PCData> queue;
    private static final int SLEEPTIME = 1000;

    public Consumer(BlockingQueue<PCData> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("start consumer id =" + Thread.currentThread().getId());

        Random random = new Random();

        try {
            while (true) {
                PCData data = queue.take();
                if (data != null) {
                    int re = data.getInData() * data.getInData();
                    System.out.println(MessageFormat.format("{0}*{1}={2}", data.getInData(), data.getInData(), re));
                    Thread.sleep(random.nextInt(SLEEPTIME));
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }


    }
}
