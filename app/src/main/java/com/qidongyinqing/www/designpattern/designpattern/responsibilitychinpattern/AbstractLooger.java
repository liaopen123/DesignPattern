package com.qidongyinqing.www.designpattern.designpattern.responsibilitychinpattern;

import android.util.Log;

public abstract class AbstractLooger {
    public AbstractLooger nextLooger;
    public static int INFOLEVEL = 1;
    public static int DEBUGLEVEL = 2;
    public static int ERRORLEVEL = 3;
    protected int level;
    private String TAG = "AbstractLooger";

    public  void setNextLooger(AbstractLooger abstractLooger){
        this.nextLooger = abstractLooger;
    }

    public void loggerMessage(int level,String message){
        if(this.level<level){

            message(message);//如果满足要求 则打印
        }
        Log.e(TAG,"levellevellevellevellevellevel:"+this.level);
        if (nextLooger != null) {
            nextLooger.loggerMessage(level,message);   //不满足要求  持有下一个对象的应用 将会执行
        }
    }

    public abstract  void message(String msg);
}
