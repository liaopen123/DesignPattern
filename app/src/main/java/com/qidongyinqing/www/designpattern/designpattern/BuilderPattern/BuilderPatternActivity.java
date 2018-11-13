package com.qidongyinqing.www.designpattern.designpattern.BuilderPattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.qidongyinqing.www.designpattern.R;
import com.qidongyinqing.www.designpattern.designpattern.BuilderPattern.newdemo1.Computer;
import com.qidongyinqing.www.designpattern.designpattern.BuilderPattern.newdemo1.ComputerBuilder;
import com.qidongyinqing.www.designpattern.designpattern.BuilderPattern.newdemo1.Director;


public class BuilderPatternActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_builder_pattern);

        //demo1
        MealBuilder mealBuilder = new MealBuilder();
        MealBuilder mealBuilder1 = new MealBuilder();
        mealBuilder.prepareMonringMeal();
        mealBuilder1.prepareAfterNoonMeal();


        //demo2
//https://blog.csdn.net/carson_ho/article/details/54910597讲解地址
        Director director = new Director();
        //相当于在builder里面把复杂的对象  构建好 在外暴露一个方法  提出出去已经生成好的对象。
        ComputerBuilder builder = new ComputerBuilder();
//沟通需求后，老板叫装机人员去装电脑
        director.construct(builder);

//装完后，组装人员搬来组装好的电脑
        Computer computer = builder.getComputer();
//组装人员展示电脑给小成看
        computer.Show();


    }
}
