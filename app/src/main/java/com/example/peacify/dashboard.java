package com.example.peacify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class dashboard extends AppCompatActivity {

    RelativeLayout mood;
    RelativeLayout quoteOfDay;
    RelativeLayout contacts;
    RelativeLayout suggestions;
    RelativeLayout checkPeople;
    RelativeLayout share;
    Button logout;

    @Override
    public void onBackPressed()
    {
        finishAffinity();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        quoteOfDay = findViewById(R.id.quote);
        mood = findViewById(R.id.mood);
        contacts = findViewById(R.id.contacts);
        suggestions = findViewById(R.id.suggestion);
        checkPeople = findViewById(R.id.checkPeople);
        share = findViewById(R.id.share);
        logout = findViewById(R.id.helpbtn);


        quoteOfDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dashboard.this, quotepage.class);
                startActivity(intent);
            }
        });

//        mood.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(dashboard.this, Moodtracer.class);
//                startActivity(intent);
//            }
//        });
//
//        checkPeople.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(dashboard.this, meditate.class);
//                startActivity(intent);
//            }
//        });
//
//        contacts.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(dashboard.this, Connect.class);
//                startActivity(intent);
//            }
//        });


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(),login_register.class));
                finish();
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "HEALTHYBEAT");
                    String shareMessage = "https://play.google.com/store/spps/details?="+BuildConfig.APPLICATION_ID+"\n\n";
                    sharingIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(sharingIntent, "Share Via"));
                }catch (Exception e){
                    Toast.makeText(dashboard.this,"Error in sharing",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}