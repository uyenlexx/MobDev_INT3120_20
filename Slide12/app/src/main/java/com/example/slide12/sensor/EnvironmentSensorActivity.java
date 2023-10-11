package com.example.slide12.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import com.example.slide12.R;

public class EnvironmentSensorActivity extends AppCompatActivity implements SensorEventListener {
    private TextView textView;
    private SensorManager sensorManager;
    private Sensor tempSensor;
    private boolean isSensorAvailable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_environment_sensor);

        textView = findViewById(R.id.textView);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if (sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE) != null) {
            tempSensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
            isSensorAvailable = true;
        } else {
            textView.setText("No Temperature Sensor Available!");
            isSensorAvailable = false;
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        textView.setText("Temperature: " + event.values[0] + "°C");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}

    @Override
    protected void onResume() {
        super.onResume();
        if (isSensorAvailable) {
            sensorManager.registerListener(this, tempSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isSensorAvailable) {
            sensorManager.unregisterListener(this);
        }
    }
}