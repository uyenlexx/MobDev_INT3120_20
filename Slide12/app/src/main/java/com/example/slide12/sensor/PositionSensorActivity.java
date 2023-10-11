package com.example.slide12.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import com.example.slide12.R;

import java.util.List;

public class PositionSensorActivity extends AppCompatActivity {
    SensorManager sensorManager = null;
    TextView textView = null;
    List list;

    SensorEventListener sel = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            float[] values = sensorEvent.values;
            textView.setText("x: " + values[0] + "\ny: " + values[1] + "\nz: " + values[2]);
        }
        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_position_sensor);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        textView = (TextView) findViewById(R.id.tvPositionSensor);
        list = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);

        // Register sensor listener for accelerometer
        if (list.size() > 0) {
            sensorManager.registerListener(sel, (Sensor) list.get(0), SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            textView.setText("Error: No Accelerometer.");
        }
    }

    // Unregister sensor listener when activity is destroyed
    @Override
    protected void onStop() {
        if (list.size() > 0) {
            sensorManager.unregisterListener(sel);
        }
        super.onStop();
    }
}