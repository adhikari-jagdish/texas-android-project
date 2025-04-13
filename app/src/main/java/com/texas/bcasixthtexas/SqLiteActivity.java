package com.texas.bcasixthtexas;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.texas.bcasixthtexas.helpers.SqliteDbHelper;

import java.util.ArrayList;

public class SqLiteActivity extends AppCompatActivity {
    EditText aslEtCourseName, aslEtCourseDuration;
    Button aslBtnSubmit;
    SqliteDbHelper sqliteDbHelper;
    ListView aslListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sq_lite);

        aslEtCourseName = findViewById(R.id.asl_et_course_name);
        aslEtCourseDuration = findViewById(R.id.asl_et_course_duration);
        aslBtnSubmit = findViewById(R.id.asl_btn_submit);
        aslListView = findViewById(R.id.asl_listview);

        sqliteDbHelper = new SqliteDbHelper(getApplicationContext());

    }

    @Override
    protected void onStart() {
        super.onStart();
        loadSqliteData();
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

                            loadSqliteData();

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

    /// This method is used to Load Data from SQLite DB into UI
    private void loadSqliteData() {

        Cursor cursor = sqliteDbHelper.getAllCourses();
        ArrayList<String> courses = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(1);
                String duration = cursor.getString(2);
                courses.add(name);
            } while (cursor.moveToNext());
        }
        cursor.close();
        ArrayAdapter coursesAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, courses);
        aslListView.setAdapter(coursesAdapter);
    }
}