package com.example.new_retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ApiInterface apiInterface;
    List<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface=Api.getclient().create(ApiInterface.class);
        Call<List<Product>> call=apiInterface.getProducts();

        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                products= response.body();

                Log.e("hii",products.get(0).getName());

            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Log.e("fail","failure", t);

            }
        });





    }

}
