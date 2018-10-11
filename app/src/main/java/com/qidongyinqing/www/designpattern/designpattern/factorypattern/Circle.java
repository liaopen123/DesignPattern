package com.qidongyinqing.www.designpattern.designpattern.factorypattern;

import android.util.Log;

public class Circle implements IShape {
    private final String TAG = this.getClass().getSimpleName();

    @Override
    public void draw() {
        Log.e(TAG,"Draw a Circle");
    }
}
