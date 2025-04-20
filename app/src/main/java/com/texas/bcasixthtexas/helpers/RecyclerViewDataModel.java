package com.texas.bcasixthtexas.helpers;

public class RecyclerViewDataModel {
    private String title;
    private String description;

    public RecyclerViewDataModel(String title, String description){
        this.title = title;
        this.description = description;
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }
}
