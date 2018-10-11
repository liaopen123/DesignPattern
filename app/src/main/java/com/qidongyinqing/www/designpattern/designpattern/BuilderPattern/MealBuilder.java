package com.qidongyinqing.www.designpattern.designpattern.BuilderPattern;

import com.qidongyinqing.www.designpattern.designpattern.BuilderPattern.item.CokeCoke;
import com.qidongyinqing.www.designpattern.designpattern.BuilderPattern.item.ColdBurger;
import com.qidongyinqing.www.designpattern.designpattern.BuilderPattern.item.HotBurger;
import com.qidongyinqing.www.designpattern.designpattern.BuilderPattern.item.PepsiCoke;

public class MealBuilder {

    public void prepareMonringMeal(){
        Meal meal = new Meal();
        meal.addItem(new HotBurger());
        meal.addItem(new PepsiCoke());

        meal.getTotalPrice();
        meal.getNames();
    }

    public void prepareAfterNoonMeal(){
        Meal meal = new Meal();
        meal.addItem(new ColdBurger());
        meal.addItem(new CokeCoke());

        meal.getTotalPrice();
        meal.getNames();
    }
}
