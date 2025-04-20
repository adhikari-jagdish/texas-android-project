package com.texas.bcasixthtexas;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.texas.bcasixthtexas.helpers.RecyclerViewDataModel;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler_view);

    }

    @Override
    protected void onStart() {
        super.onStart();

        List<RecyclerViewDataModel> recyclerViewDataList = new ArrayList<>();
        recyclerViewDataList.add(new RecyclerViewDataModel("BCA", "Bachelors of Computer Application"));
        recyclerViewDataList.add(new RecyclerViewDataModel("BTech", "Bachelor of Computer Technology"));
        recyclerViewDataList.add(new RecyclerViewDataModel("BE", "Bachelor of Computer Engineering"));
    }
}