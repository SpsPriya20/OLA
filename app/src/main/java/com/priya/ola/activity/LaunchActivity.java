package com.priya.ola.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.priya.ola.OLAActivity;
import com.priya.ola.R;

public class LaunchActivity extends AppCompatActivity {

    private Button login, signup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch_activity);
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(LaunchActivity.this);
        String token=sharedPreferences.getString("token","");
        if(!token.equals("")){
            Intent intent=new Intent(LaunchActivity.this, OLAActivity.class);
            startActivity(intent);
            finish();
        }

        login= findViewById(R.id.login);
        signup=findViewById(R.id.signup);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LaunchActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LaunchActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
