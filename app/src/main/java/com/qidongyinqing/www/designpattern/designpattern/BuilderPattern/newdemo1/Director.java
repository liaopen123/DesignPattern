package com.qidongyinqing.www.designpattern.designpattern.BuilderPattern.newdemo1;

public class Director {

    public void construct(Builder builder){
        builder.buildCPU();
        builder.buildHD();
        builder.buildMainboard();


    }


}
