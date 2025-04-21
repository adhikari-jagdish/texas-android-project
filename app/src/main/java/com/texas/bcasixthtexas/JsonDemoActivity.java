package com.texas.bcasixthtexas;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.gson.Gson;
import com.texas.bcasixthtexas.helpers.CourseModel;
import com.texas.bcasixthtexas.helpers.StudentModel;

public class JsonDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_json_demo);
        CourseModel courseModel = new CourseModel(2001, "BCA", 4);
        StudentModel studentModel =
                new StudentModel(100, "Harry", "Dave", "BCA", 5, courseModel);

        Gson gson = new Gson();

        //serialization
       String studentJson = gson.toJson(studentModel);

        Log.i("JSON DEMO", studentJson);


    }
}