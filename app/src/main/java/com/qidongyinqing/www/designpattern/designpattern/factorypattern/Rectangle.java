package com.qidongyinqing.www.designpattern.designpattern.factorypattern;

import android.util.Log;

public class Rectangle implements IShape {
    private final String TAG = this.getClass().getSimpleName();

    @Override
    public void draw() {
        Log.e(TAG,"i am rectangle");
    }
}
