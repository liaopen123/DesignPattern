package com.qidongyinqing.www.designpattern.designpattern.proxypattern.dynamicproxy;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Proxy implements InvocationHandler {
    private final Subject target;

    public Proxy(Subject target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Log.e("Proxy","proxyproxyproxyproxyproxy:"+proxy.getClass().getName());
        Log.e("Proxy","before:");
        method.invoke(target,args);
        Log.e("Proxy","after:");
        return null;
    }
}
