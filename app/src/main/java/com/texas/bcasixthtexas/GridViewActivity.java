package com.texas.bcasixthtexas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

public class GridViewActivity extends AppCompatActivity {

    Button agvBtnListView, agvBtnGridView;
    FrameLayout agvFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_grid_view);

        agvBtnGridView = findViewById(R.id.agv_btn_gridView);
        agvBtnListView = findViewById(R.id.agv_btn_listview);
        agvFrameLayout = findViewById(R.id.agv_frameLayout);

    }

    @Override
    protected void onStart() {
        super.onStart();

        agvBtnListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        agvBtnGridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void replaceFragment(Fragment currentFragment){

    }

}