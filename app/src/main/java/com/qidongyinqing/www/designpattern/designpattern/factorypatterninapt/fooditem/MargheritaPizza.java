package com.qidongyinqing.www.designpattern.designpattern.factorypatterninapt.fooditem;


import com.qidongyinqing.www.designpattern.designpattern.factorypatterninapt.fooditem.base.Meal;


//@Factory(type = MargheritaPizza.class,id = "MargheritaPizza")
public class MargheritaPizza implements Meal {
    @Override
    public float getPrice() {
        return 66.5f;
    }
}