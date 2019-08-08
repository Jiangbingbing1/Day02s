package com.bw.day05.util;

import com.bw.day05.MyApi;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MyOkHttp {

    private OkHttpClient okHttpClient;
    private static final MyOkHttp ourInstance = new MyOkHttp();
    private final MyApi myApi;

    public static MyOkHttp getInstance() {
        return ourInstance;
    }

    private MyOkHttp() {
        HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor();
        loggingInterceptor=loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient=new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5,TimeUnit.SECONDS)
                .addNetworkInterceptor(loggingInterceptor)
                .build();

        Retrofit retrofit=new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://172.17.8.100/small/")
                .client(okHttpClient)
                .build();

        myApi = retrofit.create(MyApi.class);

    }

    public interface MyCallback{
        void success(String json);
        void error(String error);
    }
    private MyCallback myCallback;
    public void GetRequest(final MyCallback myCallback){
         this.myCallback=myCallback;
         myApi.getInfo().subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Observer<ResponseBody>() {
                     @Override
                     public void onCompleted() {

                     }

                     @Override
                     public void onError(Throwable e) {
                          myCallback.error(e.getMessage());
                     }

                     @Override
                     public void onNext(ResponseBody responseBody) {
                         try {
                             myCallback.success(responseBody.string());
                         } catch (IOException e) {
                             e.printStackTrace();
                         }
                     }
                 });
    }


}
