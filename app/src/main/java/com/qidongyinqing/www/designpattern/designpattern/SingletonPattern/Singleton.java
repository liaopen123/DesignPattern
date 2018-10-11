package com.qidongyinqing.www.designpattern.designpattern.SingletonPattern;

//懒汉式   构造方法一定是私有的

public class Singleton {
    public static Singleton singleton;
    private Singleton() {
    }

    public static synchronized Singleton getInstance(){
        if (singleton == null) {
            singleton = new Singleton();
        }

        return singleton;
    }
}



//饿汉式  构造方法一定是私有的
//public class Singleton {
//    public static Singleton singleton = new Singleton();
//    private Singleton() {
//    }
//
//    public static synchronized Singleton getInstance(){
//        return singleton;
//    }
//}
