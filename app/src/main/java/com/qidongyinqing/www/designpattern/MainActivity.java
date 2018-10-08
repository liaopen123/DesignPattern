package com.qidongyinqing.www.designpattern;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.qidongyinqing.www.designpattern.adapter.QuestionRVAdapter;
import com.qidongyinqing.www.designpattern.designpattern.observerpattern.ObserverPatternActivity;
import com.qidongyinqing.www.designpattern.utils.StartActivityManger;

public class MainActivity extends AppCompatActivity {
    String[] designPattern = {"工厂方法模式","抽象工厂模式","单例模式","建造者模式","原型模式","适配器模式","装饰器模式","代理模式","外观模式","桥接模式","组合模式","享元模式","策略模式","模板方法模式","观察者模式","迭代子模式","责任链模式","命令模式","备忘录模式","状态模式","访问者模式","中介者模式","解释器模式","并发型模式","线程池模式"};
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext =  this;
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.rv);
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
                }

            }
        });
    }
}
