package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void write_but(View view) {
// Write a message to the database
        FirebaseDatabase mydatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = mydatabase.getReference();
        myRef.setValue("Hello, World!");
        //Toast.makeText(getApplicationContext(), "Writing to Database", Toast.LENGTH_LONG).show();
    }
}

