package com.example.peacify;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class login_register extends AppCompatActivity {

    FirebaseAuth fAuth;
    @Override
    public void onBackPressed()
    {
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        fAuth=FirebaseAuth.getInstance();
        if(fAuth.getCurrentUser()!=null){
            Intent intent = new Intent(login_register.this, dashboard.class);
            startActivity(intent);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);
    }
    public void openLogin(View v){
        Intent intent=new Intent(login_register.this, login.class);
        startActivity(intent);

    }
    public void openRegister(View v){
        Intent intent=new Intent(login_register.this, Register.class);
        startActivity(intent);

    }
}