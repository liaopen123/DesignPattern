package com.qidongyinqing.www.designpattern.designpattern.factorypatterninapt.fooditem;


import com.qidongyinqing.www.designpattern.designpattern.factorypatterninapt.fooditem.base.Meal;

import cn.com.almostlover.annotationinterface.Factory;

@Factory(type = CalzonePizza.class,id = "CalzonePizza")
public class CalzonePizza implements Meal {
    @Override
    public float getPrice() {
        return 8.5f;
    }
}