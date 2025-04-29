package com.texas.bcasixthtexas;

import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import com.texas.bcasixthtexas.databinding.ActivityJsonRecyclerViewBinding;
import com.texas.bcasixthtexas.helpers.JsonCourseModel;
import com.texas.bcasixthtexas.helpers.JsonRecyclerViewAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonRecyclerViewActivity extends AppCompatActivity {

    ProgressBar idPB;
    RecyclerView idRVCourses;
    private ArrayList<JsonCourseModel> jsonCourseModelArrayList;

    String url = "https://jsonkeeper.com/b/WO6S";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        idPB = findViewById(R.id.idPB);
        idRVCourses = findViewById(R.id.idRVCourses);
    }

    @Override
    protected void onStart() {
        super.onStart();

        jsonCourseModelArrayList = new ArrayList<>();

        ///This method is used to fetch data from the url above
        getDataFromApi();


    }

    private void getDataFromApi() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                idPB.setVisibility(View.GONE);
                idRVCourses.setVisibility(View.VISIBLE);

                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject responseObject = response.getJSONObject(i);
                        String courseName = responseObject.getString("courseName");
                        String courseImg = responseObject.getString("courseimg");
                        String courseMode = responseObject.getString("courseMode");
                        String courseTracks = responseObject.getString("courseTracks");

                        jsonCourseModelArrayList.add(new JsonCourseModel(courseName, courseImg, courseMode, courseTracks));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                //This method is used to build the recyclerview using the data fetched
                buildRecyclerView();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(JsonRecyclerViewActivity.this, "Error fetching data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void buildRecyclerView() {
        JsonRecyclerViewAdapter jsonRecyclerViewAdapter = new JsonRecyclerViewAdapter(jsonCourseModelArrayList);
        idRVCourses.setAdapter(jsonRecyclerViewAdapter);
    }
}