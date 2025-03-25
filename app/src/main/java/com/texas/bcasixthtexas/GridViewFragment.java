package com.texas.bcasixthtexas;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;


public class GridViewFragment extends Fragment {

    GridView fgvGridView;
    String [] destinations = {"Kathmandu", "Pokhara", "Chitwan", "Nepaljung", "Bhairahawa", "Chandragiri",
    "Jankpur", "Jomsom", "Muktinath", "Mustang", "Rara", "Langtang"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_grid_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fgvGridView = view.findViewById(R.id.fgv_gridView);
        ArrayAdapter gridViewAdapter =  new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, destinations);
        fgvGridView.setAdapter(gridViewAdapter);
        
    }
}