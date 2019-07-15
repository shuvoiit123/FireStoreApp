package com.example.firebasestoredata;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {
    private ListView listView;
    private DatabaseReference databaseReference;
    private List<Student> studentList;
    private CustomArrayAdapter customArrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        studentList = new ArrayList<>();

        customArrayAdapter = new CustomArrayAdapter(DetailsActivity.this,studentList);


        listView = findViewById(R.id.listViewId);

    }

    @Override
    protected void onStart() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                studentList.clear();
                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                {
                    Student student = dataSnapshot1.getValue(Student.class);
                    studentList.add(student);
                }
                listView.setAdapter(customArrayAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        super.onStart();
    }
}
