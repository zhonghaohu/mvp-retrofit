package com.hzh.retrofit_mvp;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BaiduService {
    //请求方式为GET，参数为basil2style，因为没有变量所以下面getString方法也不需要参数
    @GET("{path}/name")
        //定义返回的方法，返回的响应体使用了ResponseBody
    Call<ResponseBody> getBaiDu(@Path("path") String path);
}
