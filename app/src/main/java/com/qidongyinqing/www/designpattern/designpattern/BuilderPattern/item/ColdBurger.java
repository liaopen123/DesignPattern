package com.qidongyinqing.www.designpattern.designpattern.BuilderPattern.item;

public class ColdBurger extends Burger {
    @Override
    public float getPrice() {
        return 5f;
    }

    @Override
    public String name() {
        return "冷汉堡";
    }
}
