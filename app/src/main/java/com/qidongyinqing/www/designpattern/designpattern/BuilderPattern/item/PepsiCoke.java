package com.qidongyinqing.www.designpattern.designpattern.BuilderPattern.item;

public class PepsiCoke extends Coke {
    @Override
    public float getPrice() {
        return 2.5f;
    }

    @Override
    public String name() {
        return "大家好 我是百事可乐";
    }
}
