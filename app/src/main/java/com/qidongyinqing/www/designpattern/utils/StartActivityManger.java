package com.qidongyinqing.www.designpattern.utils;

import android.content.Context;
import android.content.Intent;


/**
 * Created by JiaShuai on 2018/6/5.
 * 所有的activity跳转静态工厂
 * 方法必须写明备注，跳转类功能，以及参数
 */
public class StartActivityManger {


    /**
     * @param context
     */
    public static void startActivity(Context context, Class clazz) {
        context.startActivity(new Intent(context, clazz));
    }


}




