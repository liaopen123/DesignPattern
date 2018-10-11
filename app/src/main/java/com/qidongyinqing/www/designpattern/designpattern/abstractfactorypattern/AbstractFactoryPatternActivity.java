package com.qidongyinqing.www.designpattern.designpattern.abstractfactorypattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.qidongyinqing.www.designpattern.R;

public class AbstractFactoryPatternActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abstract_factory_pattern);
        AbsFactory shape = new NormalFactory().getFactory("shape");
        shape.getShape("square").draw();
        shape.getShape("rectangle").draw();
        shape.getShape("circle").draw();


        AbsFactory color = new NormalFactory().getFactory("color");
        color.getColor("red").print();
        color.getColor("green").print();
        color.getColor("yellow").print();
    }
}
