package com.message.redblinkapitask.ConnectApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public static final  String baseUrl = "https://reqres.in/api/";

    public static Retrofit retrofit = null;

    public static Retrofit getInstance(){

        if (retrofit == null)
        {
            retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
