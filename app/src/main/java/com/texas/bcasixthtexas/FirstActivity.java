package com.texas.bcasixthtexas;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;
import java.util.List;

public class FirstActivity extends AppCompatActivity {

    List<String> items = Arrays.asList("Kathmandu", "Chandragiri", "Nagarkot", "Pokhara", "Lumbini");
    Spinner afSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_first);

        afSpinner = findViewById(R.id.af_spinner);
    }

    @Override
    protected void onStart() {
        super.onStart();

        ArrayAdapter <String> adapter = new ArrayAdapter<>
                (getApplicationContext(), android.R.layout.simple_spinner_item, items);
        afSpinner.setAdapter(adapter);
    }
}