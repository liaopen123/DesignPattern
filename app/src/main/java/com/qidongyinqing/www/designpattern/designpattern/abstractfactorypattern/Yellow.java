package com.qidongyinqing.www.designpattern.designpattern.abstractfactorypattern;

import android.util.Log;

public class Yellow implements IColor {
    private  final String TAG = this.getClass().getSimpleName();

    @Override
    public void print() {
        Log.e(TAG,"print yellow");
    }
}
