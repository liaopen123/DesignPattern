package com.qidongyinqing.www.designpattern.designpattern.BuilderPattern.pack;

import android.util.Log;

public class Bottle implements Packing{

    private  final String TAG = getClass().getSimpleName();

    @Override
    public void pack() {
        Log.e(TAG,"装瓶子里");
    }
}
