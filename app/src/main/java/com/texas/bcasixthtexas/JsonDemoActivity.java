package com.texas.bcasixthtexas;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.texas.bcasixthtexas.helpers.CourseModel;
import com.texas.bcasixthtexas.helpers.StudentModel;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonDemoActivity extends AppCompatActivity {

    TextView sampleTxtForJsonDemo;
    Button btnSampleForJsonDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_json_demo);

        sampleTxtForJsonDemo = findViewById(R.id.sample_txt_for_json_demo);
        btnSampleForJsonDemo = findViewById(R.id.btn_sample_for_json_demo);

        CourseModel courseModel = new CourseModel(2001, "BCA", 4);
        StudentModel studentModel =
                new StudentModel(100, "Harry", "Dave", "BCA", 5, courseModel);

        Gson gson = new Gson();

        //serialization
       String studentJson = gson.toJson(studentModel);

        Log.i("JSON DEMO", studentJson);
    }

    @Override
    protected void onStart() {
        super.onStart();

        btnSampleForJsonDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                String url = "https://jsonplaceholder.typicode.com/todos/1";
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject jsonObject = response.getJSONObject("");
                            int userId = jsonObject.getInt("userId");
                            String title = jsonObject.getString("title");
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

                requestQueue.add(jsonObjectRequest);
                requestQueue.start();
            }
        });
    }
}