package com.bksx.mvvmforjetpack.api;

import com.bksx.mvvmforjetpack.utils.Constants;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Author JoneChen
 * @Date 2020\8\3 0003-10:19
 */
public class RetrofitClient {

    private static RetrofitClient retrofitClient;
    private Retrofit retrofit;
    public  final String BaseUrl = "https://api.github.com/";


    public RetrofitClient() {
        retrofit = new Retrofit.Builder().baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
//                .client(new OkHttpClient.Builder().build())
                .build();
    }

    public static synchronized RetrofitClient getInstance() {
        if (retrofitClient != null) {
            retrofitClient = null;
        }
        return new RetrofitClient();
    }

    public Api getApi() {
        return retrofit.create(Api.class);
    }

    private OkHttpClient getClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                HttpUrl originalUrl = original.url();
                HttpUrl url = originalUrl.newBuilder()
//                        .addQueryParameter("apikey",Constant.apikey)
                        .build();
                Request.Builder requestBuilder = original.newBuilder().url(url);
                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });
        return httpClient.build();
    }
}
