package com.example.new_retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import java.util.*;

public interface ApiInterface
{

    @GET("product/gettoprated")
    Call<List<Product>> getProducts();

}
