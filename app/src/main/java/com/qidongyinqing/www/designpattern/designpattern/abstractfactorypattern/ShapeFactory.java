package com.qidongyinqing.www.designpattern.designpattern.abstractfactorypattern;

public class ShapeFactory  extends AbsFactory{



    @Override
    public IShape getShape(String type) {
        if(type==null){
            return null;
        }

        if(type.equalsIgnoreCase("circle")){
            return new Circle();
        }else  if(type.equalsIgnoreCase("rectangle")){
            return  new Rectangle();
        }else  if(type.equalsIgnoreCase("square")){
            return  new Square();
        }
        return null;
    }

    @Override
    public IColor getColor(String type) {
     
        return null;
    }


}
