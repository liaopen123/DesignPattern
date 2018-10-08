package com.qidongyinqing.www.designpattern.designpattern.observerpattern;

import android.content.Context;

public abstract class Observer {
    protected Subject subject;
    protected  Context context;
    public abstract  void update();
}
