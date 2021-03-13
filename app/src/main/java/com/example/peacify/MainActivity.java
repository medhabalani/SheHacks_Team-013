package com.example.peacify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;
import android.view.animation.AnimationUtils;



public class MainActivity extends AppCompatActivity {

//    View first, second, third, fourth, fifth, sixth;
//    TextView t, slogan;
    Animation topAnimation, bottomAnimation, middleAnimation;
    Button goAhead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        middleAnimation = AnimationUtils.loadAnimation(this, R.anim.middle_animation);



        int SPLASH_TIME_OUT = 1500;
        new Handler().postDelayed(new Runnable(){
            public void run(){
                // check if the user is already logged in
                // then go directly to dashboard
                // else go to login page
                Intent intent = new Intent(MainActivity.this, login_register.class);
                startActivity(intent);
            }
        }, SPLASH_TIME_OUT);
//
    }
}