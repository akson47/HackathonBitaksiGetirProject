package com.yusufakson.hackathonbitaksigetirproject.service;

import com.squareup.okhttp.OkHttpClient;
import com.yusufakson.hackathonbitaksigetirproject.interfaces.IService;

import java.util.concurrent.TimeUnit;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by lenovo on 20.3.2017.
 *
 * @author yusuf akson
 */

public class ToolApi {

    public static IService getApi() {

        final OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(1, TimeUnit.MINUTES);
        client.setReadTimeout(1, TimeUnit.MINUTES);
        client.interceptors().add(new InterceptorService());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseService.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();


        return retrofit.create(IService.class);
    }
}
