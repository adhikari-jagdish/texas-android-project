package com.texas.bcasixthtexas.helpers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.texas.bcasixthtexas.R;

import java.util.List;

public class JsonRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<JsonCourseModel> jsonCourseModelList;

    public JsonRecyclerViewAdapter(List<JsonCourseModel> jsonCourseModelList) {
        this.jsonCourseModelList = jsonCourseModelList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvCourseName, tvCourseMode, tvCourseTracks;
        private ImageView ivCourseImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvCourseName = itemView.findViewById(R.id.courseName);
            tvCourseMode = itemView.findViewById(R.id.courseMode);
            tvCourseTracks = itemView.findViewById(R.id.courseTracks);
            ivCourseImg = itemView.findViewById(R.id.courseImg);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout_for_json_recycler_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int index) {
        JsonCourseModel jsonCourseModel = jsonCourseModelList.get(index);

        final ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.tvCourseName.setText(jsonCourseModel.getCourseName());
        viewHolder.tvCourseMode.setText(jsonCourseModel.getCourseMode());
        viewHolder.tvCourseTracks.setText(jsonCourseModel.getCourseTracks());
        Picasso.get().load(jsonCourseModel.getCourseImg()).into(viewHolder.ivCourseImg);
    }

    @Override
    public int getItemCount() {
        return jsonCourseModelList.size();
    }
}
