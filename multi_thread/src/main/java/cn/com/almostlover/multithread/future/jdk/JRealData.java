package cn.com.almostlover.multithread.future.jdk;

import java.util.concurrent.Callable;

public class JRealData implements Callable<String> {

    private String paras;

    public JRealData(String paras) {
        this.paras = paras;
    }

    @Override
    public String call() throws Exception {

        //这里是真正的获取数据的地方 时间比较长
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 10; i++) {

            stringBuffer.append(paras);
            synchronized (Thread.currentThread()) {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }

        return stringBuffer.toString();
    }

}
