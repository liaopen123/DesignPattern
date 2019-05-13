package com.qidongyinqing.www.designpattern.designpattern.factorypatterninapt;

import com.qidongyinqing.www.designpattern.designpattern.factorypatterninapt.fooditem.CalzonePizza;
import com.qidongyinqing.www.designpattern.designpattern.factorypatterninapt.fooditem.MargheritaPizza;
import com.qidongyinqing.www.designpattern.designpattern.factorypatterninapt.fooditem.Tiramisu;
import com.qidongyinqing.www.designpattern.designpattern.factorypatterninapt.fooditem.base.Meal;

public class PizzaStore {

public Meal order(String mealName){

    if (null == mealName) {
        throw new IllegalArgumentException("name of meal is null!");
    }
    if ("Margherita".equals(mealName)) {
        return new MargheritaPizza();
    }

    if ("Calzone".equals(mealName)) {
        return new CalzonePizza();
    }

    if ("Tiramisu".equals(mealName)) {
        return new Tiramisu();
    }
    throw new IllegalArgumentException("Unknown meal '" + mealName);
}

}
