package com.bwie.week_3.utils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpUtils {
    private static final HttpUtils ourInstance = new HttpUtils();
    public final Api api;

    public static HttpUtils getInstance() {
        return ourInstance;
    }

    private HttpUtils() {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(new LogginIntercepor())
                .build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Cantans.URL_GET)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory .create())
                .client(okHttpClient)
                .build();


        api = retrofit.create(Api.class);
    }

    class  LogginIntercepor implements Interceptor{

        @Override
        public Response intercept(Chain chain) throws IOException {

            Request request = chain.request();

            long l = System.nanoTime();
            Response response = chain.proceed(request);

            long l1 = System.nanoTime();
            return response;
        }
    }
}
