package com.message.redblinkapitask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;


import com.message.redblinkapitask.Adapter.ApiAdapter;
import com.message.redblinkapitask.ConnectApi.ApiInterface;
import com.message.redblinkapitask.ConnectApi.RetrofitClient;
import com.message.redblinkapitask.Model.Data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
   // Data dataList;
    ArrayList<Data.Datum> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        listData();
    }

    private void listData() {

        ApiInterface apiInterface = RetrofitClient.getInstance().create(ApiInterface.class);
        Call<Data> call = apiInterface.getUserData();

        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                if (response.isSuccessful())
                {

                    ApiAdapter apiAdapter = new ApiAdapter(response.body().getData(),getApplicationContext());
                  //  apiAdapter = new ApiAdapter(dataList, getApplicationContext());
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(apiAdapter);
                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {

            }
        });

    }
}