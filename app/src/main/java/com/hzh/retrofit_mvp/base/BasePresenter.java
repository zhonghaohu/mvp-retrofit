package com.hzh.retrofit_mvp.base;


public  abstract class BasePresenter<V extends IBaseView> {
    private V view;

    public V getView() {
        return view;
    }

    public void attachView(V view){
        this.view = view;
    }

    public void detachView(){
        this.view = null;
    }
}
