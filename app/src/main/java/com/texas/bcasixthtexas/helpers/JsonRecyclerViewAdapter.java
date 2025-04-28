package com.texas.bcasixthtexas.helpers;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class JsonRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<JsonCourseModel> jsonCourseModelList;

    public JsonRecyclerViewAdapter(List<JsonCourseModel> jsonCourseModelList) {
        this.jsonCourseModelList = jsonCourseModelList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
