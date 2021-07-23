package com.example.peacify;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.button.MaterialButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class quotepage extends AppCompatActivity {

    private TextView textquote;
    private MaterialButton nextquote_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_quotepage);
        // textquote = findViewById(R.id.textquote);

        final TextView textquote = (TextView) findViewById(R.id.textquote);

//        quotegenerator q = new quotegenerator();
//        textquote.setText(q.getrandomquote());

        RequestQueue queue = Volley.newRequestQueue(quotepage.this);
        String url ="https://type.fit/api/quotes";

        // Request a string response from the provided URL.
        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                    String quote="Hey There!";
                    String writer="";
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            int n = response.length();
                            int idx = (int)Math.floor(Math.random()*(n+1));
                            JSONObject obj = response.getJSONObject(idx);
                            quote = obj.getString("text");
                            writer = obj.getString("author");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        //Toast.makeText(quotepage.this, quote, Toast.LENGTH_SHORT).show();
                        textquote.setText(quote+"\n - "+writer);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                        quotegenerator quote = new quotegenerator();
                        textquote.setText(quote.getrandomquote());
                        //Toast.makeText(quotepage.this, "Error occurred", Toast.LENGTH_SHORT).show();
                    }
                });
        queue.add(jsonObjectRequest);

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

