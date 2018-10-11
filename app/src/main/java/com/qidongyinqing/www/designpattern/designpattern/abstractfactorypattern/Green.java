package com.qidongyinqing.www.designpattern.designpattern.abstractfactorypattern;

import android.util.Log;

public class Green implements IColor {
    private  final String TAG = this.getClass().getSimpleName();

    @Override
    public void print() {
        Log.e(TAG,"print green");
    }
}
