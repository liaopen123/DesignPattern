package com.qidongyinqing.www.designpattern.designpattern.observerpattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.qidongyinqing.www.designpattern.R;

public class ObserverPatternActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observer_pattern);
        init();
    }
//观察者模式   被观察对象持有观察者的应用，到数据发生变化的时候，for循环去call每个观察者的方法。实现次需求。
    private void init() {
        Subject subject = new Subject();//被观察者
        new BinaryObserver(subject, this);//观察者1
        new OctalObserver(subject, this);//观察者2


        subject.setState(999);
    }
}
