package com.nanchen.rxjava2examples.module.rxjava2.operators.item;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.trello.rxlifecycle2.android.ActivityEvent;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.subjects.BehaviorSubject;

/**
 * Created by holenzhou on 2017/9/4.
 */

public abstract class BaseLifecycleActivity extends RxOperatorBaseActivity {

    public static final String TAG = "RxLifecycle";

    private final BehaviorSubject<ActivityEvent> lifecycleSubject = BehaviorSubject.create();

    public final ObservableTransformer bindUntilEvent(@NonNull final ActivityEvent event) {
        return new ObservableTransformer() {
            @Override
            public ObservableSource apply(@io.reactivex.annotations.NonNull Observable upstream) {
                 Observable stopObservable = lifecycleSubject.filter(new Predicate<ActivityEvent>() {
                     @Override
                     public boolean test(@io.reactivex.annotations.NonNull ActivityEvent activityEvent) throws Exception {
                         return activityEvent.equals(event);
                     }
                 });

                stopObservable.subscribe(new Consumer() {
                    @Override
                    public void accept(@io.reactivex.annotations.NonNull Object o) throws Exception {
                        Log.d(TAG, "accept: " + o);
                    }
                });
                return upstream.takeUntil(stopObservable);
            }
        };
    }

    @Override
    @CallSuper
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lifecycleSubject.onNext(ActivityEvent.CREATE);
    }

    @Override
    @CallSuper
    protected void onStart() {
        super.onStart();
        lifecycleSubject.onNext(ActivityEvent.START);
    }

    @Override
    @CallSuper
    protected void onResume() {
        super.onResume();
        lifecycleSubject.onNext(ActivityEvent.RESUME);
    }

    @Override
    @CallSuper
    protected void onPause() {
        lifecycleSubject.onNext(ActivityEvent.PAUSE);
        super.onPause();
    }

    @Override
    @CallSuper
    protected void onStop() {
        lifecycleSubject.onNext(ActivityEvent.STOP);
        super.onStop();
    }

    @Override
    @CallSuper
    protected void onDestroy() {
        lifecycleSubject.onNext(ActivityEvent.DESTROY);
        super.onDestroy();
    }

}
