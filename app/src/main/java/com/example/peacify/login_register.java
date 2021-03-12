package com.example.peacify;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class login_register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);
    }
    public void openLogin(View v){
        Intent intent=new Intent(this, login.class);
        startActivity(intent);

    }
    public void openRegister(View v){
        Intent intent=new Intent(this, Register.class);
        startActivity(intent);

    }
}