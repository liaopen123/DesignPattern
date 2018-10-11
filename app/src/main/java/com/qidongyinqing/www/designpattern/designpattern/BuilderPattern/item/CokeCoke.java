package com.qidongyinqing.www.designpattern.designpattern.BuilderPattern.item;

public class CokeCoke extends Coke {
    @Override
    public float getPrice() {
        return 1.5f;
    }

    @Override
    public String name() {
        return "大家好 我是可口可乐";
    }
}
