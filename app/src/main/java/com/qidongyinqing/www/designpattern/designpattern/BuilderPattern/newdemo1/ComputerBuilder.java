package com.qidongyinqing.www.designpattern.designpattern.BuilderPattern.newdemo1;



//装机人员
public class ComputerBuilder implements Builder{
    private   String TAG = getClass().getSimpleName();

    Computer computer = new Computer();
    @Override
    public void buildCPU() {
        computer.Add("装CPU");
    }

    @Override
    public void buildMainboard() {
        computer.Add("装主板");
    }

    @Override
    public void buildHD() {
        computer.Add("装硬盘");
    }

    @Override
    public Computer getComputer() {
            return computer;
    }
}
