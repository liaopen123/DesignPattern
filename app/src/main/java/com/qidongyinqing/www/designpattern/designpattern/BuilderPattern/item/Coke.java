package com.qidongyinqing.www.designpattern.designpattern.BuilderPattern.item;

import com.qidongyinqing.www.designpattern.designpattern.BuilderPattern.pack.Packing;
import com.qidongyinqing.www.designpattern.designpattern.BuilderPattern.pack.Wrapper;

public abstract class Coke implements Item {
    @Override
    public Packing getPackWay() {
        return new Wrapper();
    }
}
