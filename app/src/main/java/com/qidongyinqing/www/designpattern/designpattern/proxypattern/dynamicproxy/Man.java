package com.qidongyinqing.www.designpattern.designpattern.proxypattern.dynamicproxy;

import android.util.Log;

public class Man implements Subject{
    private  String TAG = getClass().getSimpleName();

    @Override
    public void shopping() {
        Log.e(TAG,"MAN ALWAYS SHOPPING");
    }
}
