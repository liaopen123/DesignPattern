package com.qidongyinqing.www.designpattern.designpattern.proxypattern;

import android.util.Log;

public class SuperStar implements Schedule {
    private  final String TAG =getClass().getSimpleName() ;

    @Override
    public void doTalk() {
        Log.i(TAG,"SuperStar talk!~~~~");
    }

    @Override
    public void doPost() {
        Log.i(TAG,"SuperStar post!~~~~");
    }
}
