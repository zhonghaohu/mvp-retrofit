package com.hzh.retrofit_mvp.model;

import com.hzh.retrofit_mvp.RxjavaService;
import com.hzh.retrofit_mvp.base.ResponseObserver;
import com.hzh.retrofit_mvp.utils.RxjavaAsyncHttpUtils;
import com.hzh.retrofit_mvp.view.IHttpView;

import java.io.IOException;

import okhttp3.ResponseBody;


public class HttpModel {


    public void requestAsyncData(String url, final IHttpView iHttpView) {
        RxjavaService rxjavaService = RxjavaAsyncHttpUtils.getService(url, RxjavaService.class);
        RxjavaAsyncHttpUtils.subscribe(rxjavaService.getMessage(), new ResponseObserver<ResponseBody>(iHttpView) {
            @Override
            public void onNext(ResponseBody responseBody) {
                try {
                    iHttpView.httpResult(responseBody.string());
                } catch (IOException e) {


                }
            }
        });
    }
}
