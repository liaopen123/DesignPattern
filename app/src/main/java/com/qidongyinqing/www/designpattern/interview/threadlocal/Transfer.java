package com.qidongyinqing.www.designpattern.interview.threadlocal;

public class Transfer implements  Runnable {

    private  Bank bank;

    public Transfer(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {


        for (int i = 0; i < 100; i++) {
            bank.set();
            System.out.println(Thread.currentThread()+".."+bank.get());
        }


    }
}
