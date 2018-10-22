package com.qidongyinqing.www.designpattern.designpattern.responsibilitychinpattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.qidongyinqing.www.designpattern.R;

public class Chin0fResponsibilityPatternActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chin0f_responsibility_pattern);


        AbstractLooger loogerChin = getLoogerChin();
        loogerChin.loggerMessage(AbstractLooger.INFOLEVEL,"我选的是info");
        loogerChin.loggerMessage(AbstractLooger.DEBUGLEVEL,"我选的是debug");
        loogerChin.loggerMessage(AbstractLooger.ERRORLEVEL,"我选的是error");

    }


    public AbstractLooger getLoogerChin(){

        ERRORLooger errorLooger = new ERRORLooger();
        INFOLooger infoLooger = new INFOLooger();
        DEBUGLooger debugLooger = new DEBUGLooger();

        errorLooger.setNextLooger(infoLooger);
        infoLooger.setNextLooger(debugLooger);

        return errorLooger;
    }
}
