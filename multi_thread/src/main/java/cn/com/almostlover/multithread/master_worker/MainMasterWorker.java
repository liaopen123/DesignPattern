package cn.com.almostlover.multithread.master_worker;

import java.util.Map;
import java.util.Set;

public class MainMasterWorker {

public void  doIt(){
    Master master = new Master(new PlusWorker(), 5); //5个worker
    for (int i = 0; i < 101; i++) {
        master.submit(i);//100个子任务
    }
    master.execute();
    int result = 0;
    Map<String, Object> resultMap = master.getResultMap();
    //只要没有完成 就一直不停的调用
    while (resultMap.size()>0||!master.isCompete()){
        Set<String> keys = resultMap.keySet();
        String key  =null;
        for (String k:keys) {
            key = k;
            break;
        }
        Integer i =null;
        if (key != null) {
            i = (Integer) resultMap.get(key);

        }

        if (i != null) {
            result+=i;
        }

        if (key != null) {
            resultMap.remove(key);
        }
    }

    System.out.println("最后的计算结果"+result);
}
}
