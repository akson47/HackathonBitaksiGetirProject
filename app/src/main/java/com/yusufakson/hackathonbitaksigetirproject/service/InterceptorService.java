package com.yusufakson.hackathonbitaksigetirproject.service;

import android.util.Log;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

/**
 * Created by lenovo on 20.3.2017.
 *
 * @author yusuf akson
 */

public class InterceptorService implements Interceptor {
    private static final String TAG = InterceptorService.class.getSimpleName();
    private static final boolean LOG_ENABLED = true;


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        request = request.newBuilder()
                .build();

        Response response = chain.proceed(request);

        if (LOG_ENABLED) {

            String bodyString = response.body().string();

            logLargeString(bodyString.replace("\r", ""));
            response = response
                    .newBuilder()
                    .body(ResponseBody.create(response.body().contentType(), bodyString))
                    .build();
        }
        return response;
    }

    public void logLargeString(String str) {
        if (str.length() > 3000) {
            Log.d(TAG, str.substring(0, 3000));
            String substring = str.substring(3000);
            logLargeString(substring);
        } else {
            Log.d(TAG, str);
        }
    }
}
