package com.xiao.demo.retrofit.own;


import java.io.IOException;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by xiao on 2017/9/2.
 */

public class Test {

	public static final String TAG = "Test";

//	public static void main(String[] args) {
//		try {
//			testLogin();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	public static void testLogin() throws IOException {
		LoginRequest request = new LoginRequest();
		request.setName("Jerry");
		request.setAge(23);
		Retrofit build = OwnHttpAdapterUtil.build();
		OwnAPI ownAPI = build.create(OwnAPI.class);
		Call<Map> load = ownAPI.load(request);
		Call<Map> clone = load.clone();

		load.enqueue(new Callback<Map>() {
			@Override
			public void onResponse(Call<Map> call, Response<Map> response) {
				Map body = response.body();
				System.out.println("onResponse.[call, response]  " + body);
			}

			@Override
			public void onFailure(Call<Map> call, Throwable t) {
				t.printStackTrace();
			}
		});
		Response<Map> response = clone.execute();
		System.out.println("testLogin.[]  response.body " + response.body());
	}


}
