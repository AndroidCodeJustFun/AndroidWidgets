package com.xiao.demo.retrofit.own;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by xiao on 2017/9/2.
 */

public interface OwnAPI {

    @POST("/es")
    Call<Map> load(@Body LoginRequest request);



}
