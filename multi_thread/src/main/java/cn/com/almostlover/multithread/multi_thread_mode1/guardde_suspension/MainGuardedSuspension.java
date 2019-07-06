package cn.com.almostlover.multithread.multi_thread_mode1.guardde_suspension;

import cn.com.almostlover.multithread.multi_thread_mode1.guardde_suspension.client.ClientThread;
import cn.com.almostlover.multithread.multi_thread_mode1.guardde_suspension.server.ServerThread;

public class MainGuardedSuspension {

    public  void doIt(){
        RequestQueue requestQueue = new RequestQueue();
        for (int i = 0; i < 10; i++) {
            new ServerThread(requestQueue,"ServerThread"+i).start();
        }

        for (int i = 0; i < 100; i++) {
            new ClientThread(requestQueue,"ClientThread"+i).start();
        }

    }
}
