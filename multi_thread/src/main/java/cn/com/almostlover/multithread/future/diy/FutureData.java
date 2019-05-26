package cn.com.almostlover.multithread.future.diy;

class FutureData implements Data {
    protected RealData realData = null;
    protected boolean isReady = false;


    public synchronized void setRealData(RealData realData) {
        if (isReady) {
            return;
        }

        this.realData = realData;
        isReady = true;
        notifyAll();

    }

    @Override
    public String getResult() {

        while (!isReady) {

            synchronized (Thread.currentThread()) {

                try {
                    Thread.currentThread().wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }


        return realData.getResult();
    }
}
