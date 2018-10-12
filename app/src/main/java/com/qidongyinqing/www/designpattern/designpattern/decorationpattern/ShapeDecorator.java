package com.qidongyinqing.www.designpattern.designpattern.decorationpattern;

public class ShapeDecorator implements Shape{


    public final Shape shape;

    public ShapeDecorator(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void draw() {
        shape.draw();
    }
}
