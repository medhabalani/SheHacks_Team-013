package com.example.peacify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.lb.auto_fit_textview.AutoResizeTextView;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Moodtracer extends AppCompatActivity {


    RelativeLayout happy;
    RelativeLayout excited;
    RelativeLayout sad;
    RelativeLayout bored;
    RelativeLayout normal;
    RelativeLayout angry;
    RelativeLayout surprised;
    RelativeLayout crying;
    RelativeLayout pain;
    RelativeLayout sick;

    FirebaseFirestore fStore;
    FirebaseAuth fAuth;
    String userID;
    CharSequence desc;

    Button save,btn;
    Button logout;
    ImageView mood;
    AutoResizeTextView description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moodtracer);


        happy = findViewById(R.id.happy);
        excited = findViewById(R.id.excited);
        sad = findViewById(R.id.sad);
        angry = findViewById(R.id.angry);
        surprised = findViewById(R.id.surprised);
        bored = findViewById(R.id.bored);
        normal = findViewById(R.id.normal);
        crying = findViewById(R.id.crying);
        sick = findViewById(R.id.sick);
        pain = findViewById(R.id.pain);

        fAuth=FirebaseAuth.getInstance();
        fStore=FirebaseFirestore.getInstance();

        save = findViewById(R.id.saveBtn);
        btn = findViewById(R.id.suggestionsbtn);
        mood = findViewById(R.id.moodDisplay);
        description = findViewById(R.id.description);
        logout = findViewById(R.id.buttonx);

        description.setEnabled(true);
        description.setFocusableInTouchMode(true);
        description.setFocusable(true);
        description.setMovementMethod(null);
        description.setMinTextSize(40f);

        happy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mood.setImageResource(R.drawable.smile);
            }
        });

        excited.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mood.setImageResource(R.drawable.excited);
            }
        });

        sad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mood.setImageResource(R.drawable.sad);
                btn.setVisibility(View.VISIBLE);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),sadcrysuggestions.class));
                    }
                });
            }
        });

        surprised.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mood.setImageResource(R.drawable.surprised);
            }
        });

        bored.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mood.setImageResource(R.drawable.bored);
                btn.setVisibility(View.VISIBLE);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),boredsuggestions.class));
                    }
                });
            }
        });

        angry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mood.setImageResource(R.drawable.angry);
                btn.setVisibility(View.VISIBLE);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),angrysuggestions.class));
                    }
                });

            }
        });

        crying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mood.setImageResource(R.drawable.crying);
                btn.setVisibility(View.VISIBLE);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),sadcrysuggestions.class));
                    }
                });
            }
        });

        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mood.setImageResource(R.drawable.normal);
            }
        });

        sick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mood.setImageResource(R.drawable.sick);
                btn.setVisibility(View.VISIBLE);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),sicksuggestions.class));
                    }
                });
            }
        });

        pain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mood.setImageResource(R.drawable.pain);
                btn.setVisibility(View.VISIBLE);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),sadcrysuggestions.class));
                    }
                });

            }
        });

        Date currentTime = Calendar.getInstance().getTime();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                desc = description.getText();
                userID = Objects.requireNonNull(fAuth.getCurrentUser()).getUid();

                FirebaseDatabase rootNode = FirebaseDatabase.getInstance();
                DatabaseReference reference = rootNode.getReference("users").child(userID);
                Map<String, String> map = new HashMap<>();
                map.put("time",currentTime.toString());
                map.put("description",desc.toString());
                //map.put(currentTime.toString(),desc);
                reference.push().setValue(map);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(),login_register.class));
                finish();
            }
        });
    }
}