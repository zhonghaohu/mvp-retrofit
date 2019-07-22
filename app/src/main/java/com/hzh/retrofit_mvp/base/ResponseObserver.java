package com.hzh.retrofit_mvp.base;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class ResponseObserver<T> implements Observer<T> {

    private IBaseView baseView;

    public ResponseObserver(IBaseView baseView) {
        this.baseView = baseView;
    }

    @Override
    public void onSubscribe(Disposable d) {
    }

    @Override
    public void onError(Throwable e) {
        baseView.showToast(e.toString());
    }

    @Override
    public void onComplete() {

    }
}
