package com.qidongyinqing.www.designpattern.designpattern.responsibilitychinpattern;

import android.util.Log;

public class ERRORLooger extends AbstractLooger
{
    private  final String TAG = this.getClass().getSimpleName();

    @Override
    public void message(String msg) {
        Log.i(TAG,"我是error"+msg);
    }
}
