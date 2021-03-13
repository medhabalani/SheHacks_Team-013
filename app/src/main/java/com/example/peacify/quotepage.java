package com.example.peacify;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class quotepage extends AppCompatActivity {

    private TextView textquote;
    private MaterialButton nextquote_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_quotepage);
        // textquote = findViewById(R.id.textquote);

        final TextView textquote = (TextView) findViewById(R.id.textquote);

        quotegenerator q = new quotegenerator();
        textquote.setText(q.getrandomquote());

//        nextquote_btn.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v) {
//                quotegenerator quote = new quotegenerator();
//
//                textquote.setText(quote.getrandomquote());
//            }

    }
}

