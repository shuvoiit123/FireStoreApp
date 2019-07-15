package com.example.firebasestoredata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private EditText nameEditText,ageEditTex,phonEditText;
    private Button storeButton,loadButton;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        nameEditText = findViewById(R.id.nameEditTextId);
        ageEditTex = findViewById(R.id.ageEditTextId);
        phonEditText = findViewById(R.id.phoneEditTextId);
        storeButton = findViewById(R.id.storeButtonId);
        loadButton = findViewById(R.id.showDetailsButtonId);

        storeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });
        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),DetailsActivity.class);
                startActivity(intent);
            }
        });
    }
    public void saveData()
    {
        String name = nameEditText.getText().toString().trim();
        String age = ageEditTex.getText().toString().trim();
        String phone =phonEditText.getText().toString().trim();

        String key = databaseReference.push().getKey();
        Student student = new Student(name,age,phone);
        databaseReference.child(key).setValue(student);
        Toast.makeText(getApplicationContext(),"Succcessfully Stored",Toast.LENGTH_SHORT).show();
        nameEditText.setText("");
        ageEditTex.setText("");
        phonEditText.setText("");

    }
}
