package com.qidongyinqing.www.designpattern.designpattern.proxypattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.qidongyinqing.www.designpattern.R;

public class ProxyPatternActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proxy_pattern);
        Broker broker = new Broker();//代理类
        broker.doPost();
        broker.doTalk();
    }
}
