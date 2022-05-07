package com.example.deuni_sipvsmclassignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.time.LocalDateTime;

public class MainActivity extends AppCompatActivity {

    private EditText city_name1;
    private EditText city_temp1;
    //String c_n;
    //Editable c_t;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        city_name1 = (EditText) findViewById(R.id.cityname);
        city_temp1 = (EditText) findViewById(R.id.citytemp);


        // Write a message to the database
       // FirebaseDatabase database = FirebaseDatabase.getInstance();
      //  DatabaseReference myRef = database.getReference("message");

       // myRef.setValue("HeLoolffgon222222222222222s!");
    }

    public void write_button(View view) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("H3333562222222s!");


        String c_n = city_name1.getText().toString().trim();
        String c_t = city_temp1.getText().toString().trim();

        DatabaseReference mRef2 = FirebaseDatabase.getInstance().getReference();
        DatabaseReference NodeA = mRef2.child(c_n);
        //NodeA.push().setValue(c_t);
        DatabaseReference NodeTime = NodeA.child(c_t);

        String timestamp = LocalDateTime.now().toString();

        NodeTime.push().setValue(timestamp);


        //if(c_n.equals("stuttgart")) {
        //    //DatabaseReference mRef2 = FirebaseDatabase.getInstance().getReference();
       //     DatabaseReference NodeA = mRef2.child("stuttgart");
        //    NodeA.push().setValue(20);
       // }
       // else if (c_n.equals("london")){
       //     DatabaseReference NodeB = mRef2.child("london");
       //     NodeB.push().setValue(10);
       // }
    }
}