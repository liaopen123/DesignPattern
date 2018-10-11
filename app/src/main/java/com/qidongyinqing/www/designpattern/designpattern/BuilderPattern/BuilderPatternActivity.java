package com.qidongyinqing.www.designpattern.designpattern.BuilderPattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.qidongyinqing.www.designpattern.R;

public class BuilderPatternActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_builder_pattern);
        MealBuilder mealBuilder = new MealBuilder();
        MealBuilder mealBuilder1 = new MealBuilder();
        mealBuilder.prepareMonringMeal();
        mealBuilder1.prepareAfterNoonMeal();


    }
}
