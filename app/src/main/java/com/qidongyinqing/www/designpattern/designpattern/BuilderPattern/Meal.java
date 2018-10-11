package com.qidongyinqing.www.designpattern.designpattern.BuilderPattern;

import android.util.Log;

import com.qidongyinqing.www.designpattern.designpattern.BuilderPattern.item.Item;

import java.util.ArrayList;

public class Meal {
    private  final String TAG = this.getClass().getSimpleName();
    ArrayList<Item> meals =   new ArrayList<Item>();
    public void addItem(Item item){
        meals.add(item);
    }

    public void getTotalPrice(){
        int totalPrice = 0;
        for(Item item:meals){
           totalPrice+= item.getPrice();
        }
        Log.e(TAG,"总价："+totalPrice);
    }

    public void getNames(){
        for(Item item:meals){
            Log.e(TAG,"单品："+ item.name());
        }

    }



}
