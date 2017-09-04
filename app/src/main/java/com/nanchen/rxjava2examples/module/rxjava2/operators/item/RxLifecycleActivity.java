package com.nanchen.rxjava2examples.module.rxjava2.operators.item;

import io.reactivex.Observable;

/**
 * Created by holenzhou on 2017/9/4.
 */

public class RxLifecycleActivity extends RxOperatorBaseActivity {
    @Override
    protected String getSubTitle() {
        return "RxLifecycle";
    }

    @Override
    protected void doSomething() {
        Observable.just("life");
//                .compose(RxLifecycleAndroid.bindActivity(RxLifecycleActivity.this));
    }
}
