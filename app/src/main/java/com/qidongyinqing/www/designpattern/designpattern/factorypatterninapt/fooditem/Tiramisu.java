package com.qidongyinqing.www.designpattern.designpattern.factorypatterninapt.fooditem;


import com.qidongyinqing.www.designpattern.designpattern.factorypatterninapt.fooditem.base.Meal;

import cn.com.almostlover.annotationinterface.Factory;

@Factory(type = Tiramisu.class,id = "Tiramisu")
public class Tiramisu implements Meal {
    @Override
    public float getPrice() {
        return 44.5f;
    }
}