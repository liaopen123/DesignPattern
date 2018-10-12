package com.qidongyinqing.www.designpattern.designpattern.decorationpattern;

import android.util.Log;

public class RedShapeDecorator extends ShapeDecorator{


    private  final String TAG = getClass().getSimpleName();

    public RedShapeDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        shape.draw();
        Log.e(TAG,"我有做了其他的事情。");
    }
}
