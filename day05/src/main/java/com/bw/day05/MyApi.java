package com.bw.day05;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import rx.Observable;

public interface MyApi {

    @GET("commodity/v1/commodityList")
    Observable<ResponseBody> getInfo();

}
