package com.example.sensorapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    private SensorManager sensorManager;
    private Sensor proximitySensor;
    private SensorEventListener proximitySensorListener;
    TextView textView2id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        textView2id = (TextView) findViewById(R.id.textView2id);
        //check if sensor is available
        //if (proximitySensor == null) {
        //    Toast.makeText(this, "Sensor is not available", Toast.LENGTH_LONG).show();
        //    finish();
        //}

        proximitySensorListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                textView2id.setText("dis:"+sensorEvent.values[0]);
             //   if (sensorEvent.values[0] < proximitySensor.getMaximumRange()){
             //       textView2id.setText("dis:"+sensorEvent.values[0]);
             //   //getWindow().getDecorView().setBackground(Color.RED);
           // }else{
           //         textView2id.setText("dis:"+sensorEvent.values[0]);
           //     //getWindow().getDecorView().setBackground(Color.GREEN);
           // }

        }

        @Override
        public void onAccuracyChanged (Sensor sensor,int i){

        }
    };

        sensorManager.registerListener(proximitySensorListener,proximitySensor,sensorManager.SENSOR_DELAY_NORMAL);
}
    @Override
    protected void onPause() {
        super.onPause();

        sensorManager.unregisterListener(proximitySensorListener);
    }

}