package com.qidongyinqing.www.designpattern.designpattern.factorypatterninapt.fooditem;

import com.qidongyinqing.www.designpattern.designpattern.factorypatterninapt.fooditem.base.Meal;

public class Tiramisu implements Meal {
    @Override
    public float getPrice() {
        return 44.5f;
    }
}