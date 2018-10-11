package com.qidongyinqing.www.designpattern.designpattern.abstractfactorypattern;

public class ColorFactory extends AbsFactory{



    @Override
    public IShape getShape(String type) {
        return null;
    }

    @Override
    public IColor getColor(String type) {
        if(type==null){
            return null;
        }

        if(type.equalsIgnoreCase("yellow")){
            return new Yellow();
        }else  if(type.equalsIgnoreCase("red")){
            return  new Red();
        }else  if(type.equalsIgnoreCase("green")){
            return  new Green();
        }
        return null;
    }


}
