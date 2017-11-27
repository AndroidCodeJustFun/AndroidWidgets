package com.xiao.demo.retrofit.own;

import android.util.Log;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by xiao on 2017/9/2.
 */

public class OwnHttpAdapterUtil {

	public static final String TAG = "OwnHttpAdapterUtil";

	private static String URL = "http://116.196.90.4:8080/loadbalancer/";

	private static String URL2 = "http://116.196.90.4:8081/loadbalancer/";


	private String PATH_LOAD = "/load";

	private String PATH_ES = "/es";

	private String PATH_ES2 = "/es2";


	public static final int TIMEOUT = 30;

	public static Retrofit build() {
		OkHttpClient client = new OkHttpClient.Builder().writeTimeout(TIMEOUT, TimeUnit.SECONDS)
				.connectTimeout(TIMEOUT, TimeUnit.SECONDS)
				.readTimeout(TIMEOUT, TimeUnit.SECONDS)
				.addInterceptor(new Interceptor() {
					@Override
					public Response intercept(Chain chain) throws IOException {
						Request request = chain.request();
						Headers headers = request.headers();
						return chain.proceed(request);
					}
				})
				.addNetworkInterceptor(new Interceptor() {
					@Override
					public Response intercept(Chain chain) throws IOException {
						Request request = chain.request();
						return chain.proceed(request);
					}
				})
				.build();

		Retrofit build = new Retrofit.Builder().client(client).baseUrl(URL2).addConverterFactory(GsonConverterFactory.create()).build();
		return build;
	}


	public static void load(LoginRequest request) {
		Call<Map> load = build().create(OwnAPI.class).load(request);
		load.enqueue(new Callback<Map>() {
			@Override
			public void onResponse(Call<Map> call, retrofit2.Response<Map> response) {
				Log.e(TAG, "onResponse: " + response.body());
				Log.e(TAG, "onResponse: " + response);
			}

			@Override
			public void onFailure(Call<Map> call, Throwable t) {
				t.printStackTrace();
			}
		});
	}

}
