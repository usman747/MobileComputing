package com.example.assignment3_logger;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Tag;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText city_name1;
    private EditText city_temp1;
    String TAG;

    private TextView display_read_city;
    private TextView display_read_temp;

    private ValueEventListener updateListener;

    private DatabaseReference root;
    private DatabaseReference location_node;
    private DatabaseReference city_node;
    private DatabaseReference time_node;

    //private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        city_name1 = (EditText) findViewById(R.id.cityname);
        city_temp1 = (EditText) findViewById(R.id.citytemp);

        display_read_city = (TextView) findViewById(R.id.textView_cityname);
        display_read_temp = (TextView) findViewById(R.id.textView_citytemp);

        // Write a message to the database
        //FirebaseDatabase database = FirebaseDatabase.getInstance();
        //DatabaseReference myRef = database.getReference("message");
        //myRef.setValue("Hello, World!");


    }

    public void write_button(View view) {
        /*
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        myRef.setValue("Hello, World!");

         */


        String c_n = city_name1.getText().toString();
        String c_t = city_temp1.getText().toString();

        root = FirebaseDatabase.getInstance().getReference();

        location_node = root.child("location");


        city_node = location_node.child(c_n);


        String timestamp = LocalDate.now().toString(); //was giving error on datetime...so only date
        time_node = city_node.child(timestamp);

        time_node.push().setValue(c_t);


    }

    public void read_button(View view) {
        /*
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

         */


         /*

        final List<String> cities = new ArrayList<String>();

        mRef2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Object ob = dataSnapshot.getValue();
                Log.i(TAG, ob.toString());
                for (String key : ((HashMap<String, Object>)ob).keySet()) {
                    Log.i(TAG, key);
                    cities.add(key);
                }

                Toast.makeText(getApplicationContext(),cities,Toast.LENGTH_SHORT).show();

                //display_read_temp.setText(String.valueOf(cities));

                //Spinner citySpinner = (Spinner) findViewById(R.id.spinner_city);
                //ArrayAdapter<String> cityAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, cities);
                //cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                //citySpinner.setAdapter(cityAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

         */




/*

        // Read from the database
        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);

                Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();

                //display_read_city.setText(value);
                //display_read_temp.setText(String.valueOf(dataSnapshot.getValue()));
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

*/

    }
}