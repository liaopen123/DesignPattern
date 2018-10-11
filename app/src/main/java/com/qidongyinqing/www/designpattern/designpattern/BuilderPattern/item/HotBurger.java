package com.qidongyinqing.www.designpattern.designpattern.BuilderPattern.item;

public class HotBurger extends Burger {
    @Override
    public float getPrice() {
        return 25f;
    }

    @Override
    public String name() {
        return "热汉堡";
    }
}
