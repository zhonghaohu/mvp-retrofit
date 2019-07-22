package com.hzh.retrofit_mvp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


import com.hzh.retrofit_mvp.base.BaseActivity;
import com.hzh.retrofit_mvp.presenter.AsyncHttpPresenter;
import com.hzh.retrofit_mvp.view.IHttpView;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends BaseActivity<AsyncHttpPresenter, IHttpView> implements IHttpView {
    TextView tv_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_show = findViewById(R.id.tv_show);


    }

    @Override
    public AsyncHttpPresenter initPresenter() {
        return new AsyncHttpPresenter();
    }

    @Override
    public IHttpView initView() {
        return this;
    }


    @Override
    public void httpResult(String string) {
        tv_show.setText(string);
    }

    //点击按钮触发
    public void requestData(View view) {
        getPresenter().requestData("https://www.baidu.com");
    }





    public void request2() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.baidu.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RxjavaService rxjavaService = retrofit.create(RxjavaService.class);
        rxjavaService.getMessage()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            Log.i("log", "request111111111111111111111111111111111111:" + responseBody.string());
                        } catch (IOException e) {


                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    public void request1() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.baidu.com")
                .build();
        BaiduService baiduService = retrofit.create(BaiduService.class);
        Call<ResponseBody> call = baiduService.getBaiDu("zhangsan");

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Log.i("log", response.body().string());
                } catch (IOException e) {


                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

    }


}
