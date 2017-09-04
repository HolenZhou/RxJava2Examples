package com.nanchen.rxjava2examples.module.rxjava2.operators.item;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by holenzhou on 2017/9/4.
 */

public class RxComposeActivity extends RxOperatorBaseActivity {
    @Override
    protected String getSubTitle() {
        return "compose";
    }

    @Override
    protected void doSomething() {
        Observable.just(1)
                .compose(new MyObservableTransformer())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(@NonNull String s) throws Exception {
                        mRxOperatorsText.append(s);
                    }
                });
    }

    class MyObservableTransformer implements ObservableTransformer<Integer, String> {

        @Override
        public ObservableSource<String> apply(@NonNull Observable<Integer> upstream) {
            return upstream.subscribeOn(Schedulers.io())
                    .map(new Function<Integer, String>() {
                        @Override
                        public String apply(@NonNull Integer integer) throws Exception {
                            return integer + "-map";
                        }
                    })
                    .observeOn(AndroidSchedulers.mainThread());
        }
    }

}
