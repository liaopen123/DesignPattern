package com.qidongyinqing.www.designpattern.designpattern.proxypattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.qidongyinqing.www.designpattern.R;
import com.qidongyinqing.www.designpattern.designpattern.proxypattern.dynamicproxy.Man;
import com.qidongyinqing.www.designpattern.designpattern.proxypattern.dynamicproxy.Subject;

import java.lang.reflect.Proxy;

public class ProxyPatternActivity extends AppCompatActivity {

    private String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proxy_pattern);
//        Broker broker = new Broker();//代理类
//        broker.doPost();
//        broker.doTalk();

        //动态代理
        Subject man = new Man();
        com.qidongyinqing.www.designpattern.designpattern.proxypattern.dynamicproxy.Proxy proxy = new com.qidongyinqing.www.designpattern.designpattern.proxypattern.dynamicproxy.Proxy(man);
        Subject subject = (Subject) Proxy.newProxyInstance(man.getClass().getClassLoader(), man.getClass().getInterfaces(), proxy);
        subject.shopping();
        Log.e(TAG,subject.getClass().getName());
    }
}
