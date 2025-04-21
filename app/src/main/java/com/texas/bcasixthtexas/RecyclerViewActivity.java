package com.texas.bcasixthtexas;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.texas.bcasixthtexas.helpers.RecyclerViewAdapter;
import com.texas.bcasixthtexas.helpers.RecyclerViewDataModel;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    RecyclerView arvRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler_view);

        arvRecyclerView = findViewById(R.id.arv_recycler_view);

    }

    @Override
    protected void onStart() {
        super.onStart();

        List<RecyclerViewDataModel> recyclerViewDataList = new ArrayList<>();
        recyclerViewDataList.add(new RecyclerViewDataModel("BCA", "Bachelors of Computer Application"));
        recyclerViewDataList.add(new RecyclerViewDataModel("BTech", "Bachelor of Computer Technology"));
        recyclerViewDataList.add(new RecyclerViewDataModel("BE", "Bachelor of Computer Engineering"));

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(recyclerViewDataList);
        arvRecyclerView.setAdapter(recyclerViewAdapter);
    }
}