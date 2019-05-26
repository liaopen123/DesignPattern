package cn.com.almostlover.multithread.future.diy;

public class Client {

    public Data request(final String queryStr){
        final FutureData futureData = new FutureData();
        new Thread(){
            @Override
            public void run() {
                RealData realData = new RealData(queryStr); //真真正正的很慢的操作在这里 已在在构建  这个方法执行的慢 要等很久
                futureData.setRealData(realData);//当拿到数据 就去唤醒
            }
        }.start();

        return futureData;
    }
}
