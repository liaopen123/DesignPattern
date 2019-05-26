package cn.com.almostlover.multithread.future;

public class MainFuture {

    public void doIt(){
        Client client = new Client();
        Data nameData = client.request("name");
        System.out.println("请求完毕");

        try {
            Thread.sleep(3000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("请求完毕:"+ nameData.getResult());

    }
}
