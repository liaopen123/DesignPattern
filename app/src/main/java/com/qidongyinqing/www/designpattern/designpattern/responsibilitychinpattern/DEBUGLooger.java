package com.qidongyinqing.www.designpattern.designpattern.responsibilitychinpattern;

import android.util.Log;

public class DEBUGLooger extends AbstractLooger
{
    private  final String TAG = this.getClass().getSimpleName();

    @Override
    public void message(String msg) {
        Log.i(TAG,"我是debug"+msg);
    }
}
