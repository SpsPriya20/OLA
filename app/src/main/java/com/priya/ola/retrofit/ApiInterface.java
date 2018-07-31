package com.priya.ola.retrofit;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiInterface {
    @POST("login")
    Call<JsonObject> loginApi(@Body JsonObject data);
    @POST("register")
    Call<JsonObject> registerApi(@Body JsonObject data);
    @GET("ride-requests/histories")
    Call<JsonObject>historyApi(@Header("Authorization")String token);
}
