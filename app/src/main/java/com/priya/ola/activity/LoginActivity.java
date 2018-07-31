package com.priya.ola.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.priya.ola.OLAActivity;
import com.priya.ola.R;
import com.priya.ola.retrofit.ApiController;
import com.priya.ola.retrofit.ApiInterface;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private EditText Countrycode,Mobileno,Password;
    private Button Login;
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        Countrycode=findViewById(R.id.countrycodeEt);
        Mobileno=findViewById(R.id.mobile_numberEt);
        Password=findViewById(R.id.passwordEt);
        Login=findViewById(R.id.LoginBt);
        apiInterface = ApiController.getClient().create(ApiInterface.class);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Password.length()>6){

                }
                if(Mobileno.length()==10){

                }
                login();
            }
        });

    }

    private void  login(){
        JsonObject object = new JsonObject();
        object.addProperty("country_code",Countrycode.getText().toString());
        object.addProperty("password",Password.getText().toString());
        object.addProperty("mobile_number",Mobileno.getText().toString());
        Call<JsonObject> loginApiCall = apiInterface.loginApi(object);
        loginApiCall.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                    Log.d("RESPONSE",response.body().getAsJsonObject().toString());
                    try {
                        JSONObject result = new JSONObject(response.body().getAsJsonObject().toString());
                        boolean success= result.getBoolean("success");
                        if (success==true){
                            Toast.makeText(LoginActivity.this,"login successfull",Toast.LENGTH_SHORT).show();
                            JSONObject data = result.getJSONObject("data");
                            String token = data.getString("accesss_token");


                            SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
                            SharedPreferences.Editor editor=sharedPreferences.edit();
                            editor.putString("token",token);
                            editor.commit();

                            Intent intent=new Intent(LoginActivity.this, OLAActivity.class);
                            startActivity(intent);


                            /*
                            Intent intent=new Intent(LoginActivity.this,UserInfoActivity.class);



                            JSONObject user= data.getJSONObject("user");
                            String fname=user.getString("fname");
                            String lname=user.getString("lname");
                            String Email = user.getString("email");
                            String Mobileno = user.getString("mobile_number");
                            intent.putExtra("fname",fname);
                            intent.putExtra("lname",lname);
                            intent.putExtra("Email",Email);
                            intent.putExtra("Mobileno",Mobileno);
                            startActivity(intent);
                            Log.d("TOKEN",token);*/
                        }


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }
    private void Dialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
    }
}
