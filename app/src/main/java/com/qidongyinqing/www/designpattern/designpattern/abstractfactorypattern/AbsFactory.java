package com.qidongyinqing.www.designpattern.designpattern.abstractfactorypattern;

public abstract class AbsFactory {

    public abstract IShape getShape(String type);
    public abstract IColor getColor(String type);
}
