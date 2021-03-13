package com.example.peacify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class sadcrysuggestions extends AppCompatActivity {
    Button help,meditate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sadcrysuggestions);
        help = findViewById(R.id.helpbtn);
        meditate = findViewById(R.id.meditatebtn);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Connect.class));
            }
        });
        meditate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),meditate.class));
            }
        });
    }
}