package com.qidongyinqing.www.designpattern.designpattern.BuilderPattern.item;

import com.qidongyinqing.www.designpattern.designpattern.BuilderPattern.pack.Packing;

public interface Item {
    Packing getPackWay();
    float getPrice();
    String name();
}
