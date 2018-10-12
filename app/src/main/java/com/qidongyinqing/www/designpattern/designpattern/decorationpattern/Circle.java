package com.qidongyinqing.www.designpattern.designpattern.decorationpattern;

import android.util.Log;

public class Circle implements Shape{

    private  final String TAG = getClass().getSimpleName();

    @Override
    public void draw() {
        Log.e(TAG,"drawCircle");
    }
}
