package com.example.slide12.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.slide12.R;

public class MotionSensorActivity extends AppCompatActivity implements SensorEventListener {
    SensorManager sensorManager;
    private boolean isColor = false;
    private View view;
    private long lastUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motion_sensor);

        view = findViewById(R.id.textView);
        view.setBackgroundColor(Color.YELLOW);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        lastUpdate = System.currentTimeMillis();
    }

    //override SensorEventListener methods
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            getAccelerometer(event);
        }
    }

    //get accelerometer data
    private void getAccelerometer(SensorEvent event) {
        float[] values = event.values;
        // Movement
        float x = values[0];
        float y = values[1];
        float z = values[2];

        float accelationSquareRoot = (x * x + y * y + z * z)
                / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);

        long actualTime = System.currentTimeMillis();
        Toast.makeText(getApplicationContext(), String.valueOf(accelationSquareRoot) + " " +
                SensorManager.GRAVITY_EARTH, Toast.LENGTH_SHORT).show();

        if (accelationSquareRoot >= 2) {
            if (actualTime - lastUpdate < 200) {
                return;
            }
            lastUpdate = actualTime; //update lastUpdate for next shuffle
            if (isColor) {
                view.setBackgroundColor(Color.YELLOW);
            } else {
                view.setBackgroundColor(Color.BLUE);
            }
            isColor = !isColor;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        //register this class as a listener for the accelerometer sensor
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        //unregister listener
        super.onPause();
        sensorManager.unregisterListener((SensorEventListener) this);
    }
}