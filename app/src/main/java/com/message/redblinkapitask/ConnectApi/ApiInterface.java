package com.message.redblinkapitask.ConnectApi;

import com.message.redblinkapitask.Model.Data;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET ("users")
    Call<Data> getUserData();

}
