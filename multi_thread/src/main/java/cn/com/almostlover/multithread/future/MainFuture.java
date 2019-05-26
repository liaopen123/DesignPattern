package cn.com.almostlover.multithread.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import cn.com.almostlover.multithread.future.diy.Client;
import cn.com.almostlover.multithread.future.diy.Data;
import cn.com.almostlover.multithread.future.jdk.JRealData;

public class MainFuture {

    public void doIt() {
        Client client = new Client();
        Data nameData = client.request("name");//这个开始请求数据
        System.out.println("请求完毕");
        synchronized (Thread.currentThread()) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            System.out.println("请求完毕:" + nameData.getResult()); //future getRealData一直在等realdata拿到数据wait()


    }

    public void doWithJdk(){
        FutureTask<String> futureTask = new FutureTask<>(new JRealData("lph"));
        ExecutorService executor = Executors.newFixedThreadPool(1);

        executor.submit(futureTask);
        //做延时操作
        System.out.println("请求完毕");
        synchronized (Thread.currentThread()) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            System.out.println("请求完毕:" + futureTask.get()); //future getRealData一直在等realdata拿到数据wait()
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
