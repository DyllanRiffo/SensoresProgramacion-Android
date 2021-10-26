package com.DyllanRiffo.sensores;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    TextView  x,y,z;
    Sensor magnetico , giroscopio;
    SensorManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        z = (TextView) findViewById(R.id.z);
        y = (TextView) findViewById(R.id.y);
        x = (TextView) findViewById(R.id.x);

        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        magnetico =(Sensor) sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        sm.registerListener(this,magnetico,SensorManager.SENSOR_DELAY_NORMAL);
        giroscopio =(Sensor) sm.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        sm.registerListener(this,giroscopio,SensorManager.SENSOR_DELAY_NORMAL);


    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        switch (event.sensor.getType()){
            case Sensor.TYPE_MAGNETIC_FIELD:
                x.setText(String.format("%f",event.values[0]));
                z.setText(String.format("%f",event.values[2]));
                break;
            case Sensor.TYPE_GYROSCOPE:
                y.setText(String.format("%f",event.values[1]));
                break;
        }




    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}