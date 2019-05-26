package cn.com.almostlover.multithread.future.diy;

class RealData {
    protected String result;

    public RealData(String queryStr) {
        //这里是真正的获取数据的地方 时间比较长
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 10; i++) {

            stringBuffer.append(queryStr);
            synchronized (Thread.currentThread()) {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        result = stringBuffer.toString();
    }

    public String getResult() {
        return result;
    }
}
