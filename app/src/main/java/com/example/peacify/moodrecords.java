package com.example.peacify;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.ArrayList;

public class moodrecords extends AppCompatActivity {
    private RecyclerView recyclerView;
    FirebaseDatabase rootNode = FirebaseDatabase.getInstance();
    DatabaseReference reference = rootNode.getReference("users");
    private MyAdapter adapter;
    FirebaseAuth fAuth;
    String UserID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moodrecords);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Model> list;
        list=new ArrayList<>();
        adapter=new MyAdapter(this,list);
        recyclerView.setAdapter(adapter);

        fAuth = FirebaseAuth.getInstance();
        //fStore = FirebaseFirestore.getInstance();
        UserID = fAuth.getCurrentUser().getUid();

        reference.child(UserID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    Model model = dataSnapshot.getValue(Model.class);
                    String xyz = (String) dataSnapshot.child("description").getValue();
                    //Model model1 = null;
                    //model.time = (String) dataSnapshot.child("time").getValue();
                    model.description = xyz;
                    //model.description = dataSnapshot.child("description").getValue();
                    Toast.makeText(moodrecords.this, "Description: "+xyz, Toast.LENGTH_SHORT).show();

                    //Toast.makeText(moodrecords.this, "Description: "+dataSnapshot.child("description").getValue(), Toast.LENGTH_SHORT).show();
                    list.add(model);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}