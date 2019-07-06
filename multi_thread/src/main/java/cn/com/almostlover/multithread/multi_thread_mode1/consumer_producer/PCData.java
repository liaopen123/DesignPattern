package cn.com.almostlover.multithread.multi_thread_mode1.consumer_producer;

class PCData {
    private final int inData;

    public PCData(int incrementAndGet) {
        inData = incrementAndGet;
    }

    public PCData(String d) {
        inData = Integer.valueOf(d);
    }

    public int getInData() {
        return inData;
    }

    @Override
    public String toString() {
        return "PCData{" +
                "inData=" + inData +
                '}';
    }
}

