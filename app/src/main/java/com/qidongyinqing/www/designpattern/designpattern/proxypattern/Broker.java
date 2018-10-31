package com.qidongyinqing.www.designpattern.designpattern.proxypattern;

import android.util.Log;


public class Broker implements Schedule {


    private  final String TAG = getClass().getSimpleName();
    private  SuperStar superStar;

    public Broker() {
        superStar = new SuperStar();
    }

    public Broker(SuperStar superStar) {
        this.superStar = superStar;
    }
    @Override
    public void doTalk() {
        Log.i(TAG,"broker prepare talk paper!~~~~");
        superStar.doTalk();
    }

    @Override
    public void doPost() {
        Log.i(TAG,"broker prepare post paper!~~~~");
        superStar.doPost();

    }
}
