package com.hzh.retrofit_mvp.presenter;


import com.hzh.retrofit_mvp.base.BasePresenter;
import com.hzh.retrofit_mvp.model.HttpModel;
import com.hzh.retrofit_mvp.view.IHttpView;

public class AsyncHttpPresenter extends BasePresenter<IHttpView> {

    private HttpModel httpModel;

    public AsyncHttpPresenter() {
        httpModel = new HttpModel();
    }

    public void requestData(String url){
        httpModel.requestAsyncData(url,getView());
    }

}
