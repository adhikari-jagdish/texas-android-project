package com.texas.bcasixthtexas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RelativeLayoutActivity extends AppCompatActivity {
    TextView tvTitle, tvBca, tvCsit;
    EditText etFullName;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_relative_layout);

        etFullName = findViewById(R.id.et_full_name);
        btnSubmit = findViewById(R.id.btn_submit);
    }

    @Override
    protected void onStart() {
        super.onStart();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TableLayoutActivity.class);
                startActivity(intent);
            }
        });
    }
}