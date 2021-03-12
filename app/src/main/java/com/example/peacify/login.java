package com.example.peacify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    EditText lemail,lpassword;
    Button lloginBtn;
    ProgressBar progressBar;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        lemail=findViewById(R.id.email2);
        lpassword=findViewById(R.id.password2);
        lloginBtn=findViewById(R.id.loginBtn);
        progressBar=findViewById(R.id.progressBar2);
        fAuth=FirebaseAuth.getInstance();

        lloginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=lemail.getText().toString().trim();
                String pass=lpassword.getText().toString().trim();
                if(TextUtils.isEmpty(email)){
                    lemail.setError("Email is required.");
                    return;
                }
                if(TextUtils.isEmpty(pass)){
                    lpassword.setError("Password is required.");
                    return;
                }
                if(pass.length()<6){
                    lpassword.setError("Password must be >= 6 character.");
                }
                progressBar.setVisibility(View.VISIBLE);
                fAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(login.this, "Logged in successfully", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(login.this, "Error: "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.INVISIBLE);
                        }
                    }
                });
            }
        });
    }
}