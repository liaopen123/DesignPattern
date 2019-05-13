package com.qidongyinqing.www.designpattern.designpattern.factorypatterninapt.fooditem;

import com.qidongyinqing.www.designpattern.designpattern.factorypatterninapt.fooditem.base.Meal;

public class CalzonePizza implements Meal {
    @Override
    public float getPrice() {
        return 8.5f;
    }
}