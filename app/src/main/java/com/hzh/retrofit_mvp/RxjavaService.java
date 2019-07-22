package com.hzh.retrofit_mvp;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;

public interface RxjavaService {

    @GET("/")
    Observable<ResponseBody> getMessage();
}
