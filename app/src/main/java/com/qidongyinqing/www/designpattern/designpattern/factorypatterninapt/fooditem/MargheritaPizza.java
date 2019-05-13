package com.qidongyinqing.www.designpattern.designpattern.factorypatterninapt.fooditem;

import com.qidongyinqing.www.designpattern.designpattern.factorypatterninapt.fooditem.base.Meal;

public class MargheritaPizza implements Meal {
    @Override
    public float getPrice() {
        return 66.5f;
    }
}