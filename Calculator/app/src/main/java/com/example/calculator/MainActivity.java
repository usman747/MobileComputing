package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText etn1;
    private EditText etn2;
    private TextView tvResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etn1 = (EditText) findViewById(R.id.etn1);
        etn2 = (EditText) findViewById(R.id.etn2);
        tvResult = (TextView) findViewById(R.id.tvResult);
    }


    public void butsub(View view) {
        float n1 = Float.parseFloat(etn1.getText().toString());
        float n2 = Float.parseFloat(etn2.getText().toString());
        //float n1 = Integer.parseInt(etn1.getText().toString());
        //float n2 = Integer.parseInt(etn2.getText().toString());
        float sub = n1 - n2;
        tvResult.setText(String.valueOf(sub));
    }

    public void btnsum(View view) {
        float n1 = Float.parseFloat(etn1.getText().toString());
        float n2 = Float.parseFloat(etn2.getText().toString());
        float sum = n1 + n2;
        tvResult.setText(String.valueOf(sum));

    }

    public void butmulti(View view) {
        float n1 = Float.parseFloat(etn1.getText().toString());
        float n2 = Float.parseFloat(etn2.getText().toString());
        float sum = n1 * n2;
        tvResult.setText(String.valueOf(sum));
    }

    public void butdiv(View view) {
        float n1 = Float.parseFloat(etn1.getText().toString());
        float n2 = Float.parseFloat(etn2.getText().toString());
        float sum = n1 / n2;
        tvResult.setText(String.valueOf(sum));
    }
}