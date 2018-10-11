package com.qidongyinqing.www.designpattern.designpattern.abstractfactorypattern;

public class NormalFactory {

    public AbsFactory getFactory(String type){
        if (type == null) {
            return null;
        }
        if(type.equalsIgnoreCase("shape")){
            return new ShapeFactory();
        }else if(type.equalsIgnoreCase("color")){
            return new ColorFactory();
        }else {
            return null;
        }
    }
}
