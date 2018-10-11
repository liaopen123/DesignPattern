package com.qidongyinqing.www.designpattern.designpattern.factorypattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.qidongyinqing.www.designpattern.R;

public class FactoryPatternActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factory_pattern);

        ShapeFactory shapeFactory = new ShapeFactory();
        shapeFactory.getShape("circle").draw();
        shapeFactory.getShape("square").draw();

    }
}
