package com.qidongyinqing.www.designpattern.interview.threadlocal;

public class Bank {
    public  ThreadLocal<Integer> threadLocal  = new ThreadLocal(){
        @Override
        protected Integer initialValue() {
            return 100;
        }
    };

    public void set(){
         threadLocal.set(threadLocal.get()+10);
    }


    public int get(){
        return  threadLocal.get();
    }


}
