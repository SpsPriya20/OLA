package com.priya.ola.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiController {

    private static Retrofit client;

     private static String baseUrl = "http://139.59.79.130/api/v1/user/";
    public static Retrofit getClient() {
        if (client==null){
            client=new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(baseUrl).build();
        }
        return client;
    }
}
