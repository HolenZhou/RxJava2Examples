package com.nanchen.rxjava2examples.model;

import com.nanchen.rxjava2examples.base.BaseActivity;

/**
 * Author: nanchen
 * Email: liushilin520@foxmail.com
 * Date: 2017-06-20  15:01
 */

public class OperatorModel {

    public String title;
    public String des;
    public Class<? extends BaseActivity> activityClass;

    public OperatorModel(String title, String des) {
        this.title = title;
        this.des = des;
    }

    public OperatorModel(String title, String des, Class<? extends BaseActivity> activityClass) {
        this.title = title;
        this.des = des;
        this.activityClass = activityClass;
    }
}
