package com.texas.bcasixthtexas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.texas.bcasixthtexas.helpers.SqliteDbHelper;

public class SqLiteActivity extends AppCompatActivity {
    EditText aslEtCourseName, aslEtCourseDuration;
    Button aslBtnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sq_lite);

        aslEtCourseName = findViewById(R.id.asl_et_course_name);
        aslEtCourseDuration = findViewById(R.id.asl_et_course_duration);
        aslBtnSubmit = findViewById(R.id.asl_btn_submit);

    }

    @Override
    protected void onStart() {
        super.onStart();

        aslBtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (aslEtCourseName != null && aslEtCourseDuration != null) {
                    if (aslEtCourseName.getText() != null && aslEtCourseDuration.getText() != null) {
                        String courseName = aslEtCourseName.getText().toString();
                        String courseDuration = aslEtCourseDuration.getText().toString();

                        if (!courseName.isEmpty() && !courseDuration.isEmpty()) {
                            SqliteDbHelper sqliteDbHelper = new SqliteDbHelper(getApplicationContext());
                            sqliteDbHelper.addNewCourse(courseName, courseDuration);

                        } else {
                            Toast.makeText(getApplicationContext(), "Please input Course Name and Duration", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(getApplicationContext(), "Please input Course Name and Duration", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(SqLiteActivity.this, "Please input Course Name and Duration", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}