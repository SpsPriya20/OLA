package com.priya.ola.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.priya.ola.R;

public class UserInfoActivity extends AppCompatActivity {

    private TextView Fname,Lname,Email,Mobileno;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Fname=findViewById(R.id.Fname);
        Lname=findViewById(R.id.lname);
        Email=findViewById(R.id.email);
        Mobileno=findViewById(R.id.Mobile);

        String firstname=getIntent().getStringExtra("fname");
       String lastname= getIntent().getStringExtra("lname");
       String EmailAddress=getIntent(). getStringExtra("Email");
       String Mobilenumber=getIntent().getStringExtra("Mobile");

    }
}
