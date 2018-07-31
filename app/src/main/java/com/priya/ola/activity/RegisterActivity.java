package com.priya.ola.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.JsonObject;
import com.priya.ola.R;
import com.priya.ola.retrofit.ApiInterface;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    private EditText fname,lname,email,password,c_code,referralcode,mobileno;
    private Button register;
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.register_activity);
        fname=findViewById(R.id.fnameEt);
        lname = findViewById(R.id.lnameEt);
        email=findViewById(R.id.emailEt);
        password=findViewById(R.id.passwordEt);
        c_code=findViewById(R.id.countrycodeEt);
        referralcode=findViewById(R.id.referralEt);
        mobileno=findViewById(R.id.mobileEt);

        register=findViewById(R.id.RegisterBt);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              register();
            }
        });
    }
    private void register(){
        JsonObject object = new JsonObject();
        object.addProperty("fname",fname.getText().toString());
        object.addProperty("lname",lname.getText().toString());
        object.addProperty("email",email.getText().toString());
        object.addProperty("country_code",c_code.getText().toString());
        object.addProperty("mobile_number",mobileno.getText().toString());
        object.addProperty("password",password.getText().toString());
        object.addProperty("referral_code",referralcode.getText().toString());
        Call<JsonObject> registerApiCall=apiInterface.registerApi(object);

        registerApiCall.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                try {
                    Log.d("RESPONSE",response.body().getAsJsonObject().toString());
                    try {
                        JSONObject result = new JSONObject((response.body().getAsJsonObject().toString()));
                    }catch (JSONException e){
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }
}
