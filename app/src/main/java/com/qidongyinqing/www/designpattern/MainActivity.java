package com.qidongyinqing.www.designpattern;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.qidongyinqing.www.designpattern.adapter.QuestionRVAdapter;
import com.qidongyinqing.www.designpattern.designpattern.BuilderPattern.BuilderPatternActivity;
import com.qidongyinqing.www.designpattern.designpattern.abstractfactorypattern.AbstractFactoryPatternActivity;
import com.qidongyinqing.www.designpattern.designpattern.decorationpattern.DecorationPatternActivity;
import com.qidongyinqing.www.designpattern.designpattern.factorypattern.FactoryPatternActivity;
import com.qidongyinqing.www.designpattern.designpattern.observerpattern.ObserverPatternActivity;
import com.qidongyinqing.www.designpattern.designpattern.proxypattern.ProxyPatternActivity;
import com.qidongyinqing.www.designpattern.designpattern.responsibilitychinpattern.Chin0fResponsibilityPatternActivity;
import com.qidongyinqing.www.designpattern.utils.StartActivityManger;

import cn.com.almostlover.apt_annotation.BindView;
import cn.com.almostlover.apt_library.BindViewTools;

public class MainActivity extends AppCompatActivity {
    String[] designPattern = {"工厂方法模式","抽象工厂模式","单例模式","建造者模式","原型模式","适配器模式","装饰器模式","代理模式","外观模式","桥接模式","组合模式","享元模式","策略模式","模板方法模式","观察者模式","迭代子模式","责任链模式","命令模式","备忘录模式","状态模式","访问者模式","中介者模式","解释器模式","并发型模式","线程池模式"};
    private Context mContext;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext =  this;
        setContentView(R.layout.activity_main);
        recyclerView =   findViewById(R.id.rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        QuestionRVAdapter mGalleryAdapeter = new QuestionRVAdapter(this);
        recyclerView.setAdapter(mGalleryAdapeter);
        mGalleryAdapeter.setData(designPattern);
        mGalleryAdapeter.setOnItemClickListener(new QuestionRVAdapter.OnItemClickListener() {
            @Override
            public void click(String  name) {
                if(name.contains("观察者模式")){
                    StartActivityManger.startActivity(mContext,ObserverPatternActivity.class);
                }else  if(name.contains("工厂方法模式")){
                    StartActivityManger.startActivity(mContext,FactoryPatternActivity.class);
                }else  if(name.contains("抽象工厂模式")){
                    StartActivityManger.startActivity(mContext,AbstractFactoryPatternActivity.class);
                }else  if(name.contains("建造者模式")){
                    StartActivityManger.startActivity(mContext,BuilderPatternActivity.class);
                }else  if(name.contains("装饰器")){
                    StartActivityManger.startActivity(mContext,DecorationPatternActivity.class);
                }else  if(name.contains("责任链模式")){
                    StartActivityManger.startActivity(mContext,Chin0fResponsibilityPatternActivity.class);
                }else  if(name.contains("代理模式")){
                    StartActivityManger.startActivity(mContext,ProxyPatternActivity.class);
                }

            }
        });
    }
}
