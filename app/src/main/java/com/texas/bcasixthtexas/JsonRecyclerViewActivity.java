package com.texas.bcasixthtexas;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ProgressBar;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import com.texas.bcasixthtexas.databinding.ActivityJsonRecyclerViewBinding;

public class JsonRecyclerViewActivity extends AppCompatActivity {

    ProgressBar idPB;
    RecyclerView idRVCourses;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        idPB = findViewById(R.id.idPB);
        idRVCourses = findViewById(R.id.idRVCourses);
    }
}