package com.nanchen.rxjava2examples.module.rxjava2.operators.item;

import android.util.Log;

import com.trello.rxlifecycle2.android.ActivityEvent;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by holenzhou on 2017/9/4.
 */

public class RxLifecycleActivity extends BaseLifecycleActivity {
    @Override
    protected String getSubTitle() {
        return "RxLifecycle";
    }

    @Override
    protected void doSomething() {
        Observable
                .interval(1, TimeUnit.SECONDS)
                .compose(bindUntilEvent(ActivityEvent.STOP))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(@NonNull Long aLong) throws Exception {
//                        mRxOperatorsText.append(aLong + "\n");
                        Log.d(TAG, "accept: " + aLong);
                    }
                });
    }
}
