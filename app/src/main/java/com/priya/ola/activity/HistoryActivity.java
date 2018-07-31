package com.priya.ola.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.JsonObject;
import com.priya.ola.model.RideHistory;
import com.priya.ola.retrofit.ApiController;
import com.priya.ola.retrofit.ApiInterface;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryActivity extends AppCompatActivity {
 private ApiInterface apiInterface;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        apiInterface= ApiController.getClient().create(ApiInterface.class);

        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        String token=sharedPreferences.getString("token","");
        Call<JsonObject>historyApi=apiInterface.historyApi(token);
        historyApi.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                Log.d("Response",response.body().toString());
                JsonObject jsonObject=response.body();

                try {
                    JSONObject result = new JSONObject(jsonObject.toString());
                    JSONObject data= result.getJSONObject("data");
                    JSONArray ride_requests=data.getJSONArray("ride_requests");

                    ArrayList<RideHistory>rideHistories=new ArrayList<>();

                    for (int i = 0; i< ride_requests.length();++i){
                        JSONObject element=ride_requests.getJSONObject(i);
                        int id=element.getInt("id");
                        String source_address =element.getString("source_address");
                        String destination_address=element.getString("destination_address");
                        JSONObject driver=element.getJSONObject("driver");
                        String fname=driver.getString("fname");
                        String vehicle_type=driver.getString("vehicle_type");
                        JSONObject invoice =element.getJSONObject("invoice");
                        String invoice_reference=invoice.getString("invoice_reference");
                        String total = invoice.getString("total");


                        RideHistory rideHistory=new RideHistory(id,source_address,destination_address,fname,vehicle_type,invoice_reference,total);
                    }
                }catch (JSONException e){

                }

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });

    }


}
