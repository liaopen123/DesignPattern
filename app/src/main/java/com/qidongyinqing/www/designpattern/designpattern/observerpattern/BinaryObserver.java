package com.qidongyinqing.www.designpattern.designpattern.observerpattern;

import android.content.Context;
import android.widget.Toast;

public class BinaryObserver extends Observer {


    private static final String TAG = "BinaryObserver";


    public BinaryObserver(Subject subject,Context context) {
        this.subject = subject;
        this.context = context;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        Toast.makeText(context, this.getClass().getSimpleName()+subject.getState(), Toast.LENGTH_SHORT).show();
    }
}
