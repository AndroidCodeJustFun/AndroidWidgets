package com.xiao.demo.retrofit.github;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by xiao on 2017/9/2.
 */

public class GitHubAdapterUtil {

    private String URL = "https://api.github.com";


    public static final int TIMEOUT = 30;

    public Retrofit build() {
        OkHttpClient client = new OkHttpClient.Builder().writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .followRedirects(true)
                .build();

        Retrofit build = new Retrofit.Builder().client(client).baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
        return build;
    }

}
