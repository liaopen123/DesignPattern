package com.qidongyinqing.www.designpattern.designpattern.decorationpattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.qidongyinqing.www.designpattern.R;

public class DecorationPatternActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decoration_pattern);
        RedShapeDecorator redShapeDecorator = new RedShapeDecorator(new Circle());
        redShapeDecorator.draw();
    }
}
