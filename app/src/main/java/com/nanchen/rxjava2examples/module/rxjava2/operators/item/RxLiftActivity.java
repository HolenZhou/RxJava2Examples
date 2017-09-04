package com.nanchen.rxjava2examples.module.rxjava2.operators.item;

import io.reactivex.Observable;
import io.reactivex.ObservableOperator;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by holenzhou on 2017/9/4.
 */

public class RxLiftActivity extends RxOperatorBaseActivity {
    @Override
    protected String getSubTitle() {
        return "lift";
    }

    @Override
    protected void doSomething() {
        Observable.just("h")
                .lift(new ObservableOperator<Integer, String>() {
                    @Override
                    public Observer<? super String> apply(@NonNull Observer<? super Integer> observer) throws Exception {
                        return new MyObserver(observer);
                    }
                })
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Integer integer) {
                        mRxOperatorsText.append(integer + "\n");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    static class MyObserver implements Observer<String> {

        private Observer<? super Integer> actual;

        public MyObserver(Observer<? super Integer> actual) {
            this.actual = actual;
        }

        @Override
        public void onSubscribe(@NonNull Disposable d) {

        }

        @Override
        public void onNext(@NonNull String s) {
            s = s + "--lift";
            actual.onNext(s.length());
        }

        @Override
        public void onError(@NonNull Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    }
}
