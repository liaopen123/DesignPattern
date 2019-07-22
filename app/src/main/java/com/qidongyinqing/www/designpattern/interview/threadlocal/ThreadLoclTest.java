package com.qidongyinqing.www.designpattern.interview.threadlocal;

public class ThreadLoclTest {

    public static void   test(){
        Transfer t = new Transfer(new Bank());
        new Thread(t).start();
        new Thread(t).start();



    }
}
