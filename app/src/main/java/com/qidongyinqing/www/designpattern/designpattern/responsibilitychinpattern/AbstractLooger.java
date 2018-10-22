package com.qidongyinqing.www.designpattern.designpattern.responsibilitychinpattern;

public abstract class AbstractLooger {
    public AbstractLooger nextLooger;
    public static int INFOLEVEL = 0;
    public static int DEBUGLEVEL = 1;
    public static int ERRORLEVEL = 2;
    public static int level;

    public  void setNextLooger(AbstractLooger abstractLooger){
        this.nextLooger = abstractLooger;
    }

    public void loggerMessage(int level,String message){
        if(this.level<level){
            message(message);//如果满足要求 则打印
        }
        if (nextLooger != null) {
            nextLooger.loggerMessage(level,message);   //不满足要求  持有下一个对象的应用 将会执行
        }
    }

    public abstract  void message(String msg);
}
