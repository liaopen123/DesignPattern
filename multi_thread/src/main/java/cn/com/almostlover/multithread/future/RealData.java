package cn.com.almostlover.multithread.future;

class RealData {
    protected String result;

    public RealData(String queryStr) {

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 10; i++) {

            stringBuffer.append(queryStr);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        result = stringBuffer.toString();
    }

    public String getResult() {
        return result;
    }
}
