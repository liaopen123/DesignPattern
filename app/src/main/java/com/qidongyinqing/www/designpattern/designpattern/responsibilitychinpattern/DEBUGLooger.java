package com.qidongyinqing.www.designpattern.designpattern.responsibilitychinpattern;

import android.util.Log;

public class DEBUGLooger extends AbstractLooger
{
    private  final String TAG = this.getClass().getSimpleName();
    public DEBUGLooger(int level){
        this.level = level;
//        Log.i(TAG,"当前的AbstractLoogerlevel"+AbstractLooger.level);
    }
    @Override
    public void message(String msg) {
        Log.i(TAG,"我是debug"+msg);
    }
}
