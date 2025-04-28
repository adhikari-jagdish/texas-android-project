package com.texas.bcasixthtexas.helpers;

public class JsonCourseModel {

    private String courseName;
    private String courseImg;
    private String courseMode;
    private String courseTracks;

    public JsonCourseModel(String courseName, String courseImg, String courseMode, String courseTracks) {
        this.courseName = courseName;
        this.courseImg = courseImg;
        this.courseMode = courseMode;
        this.courseTracks = courseTracks;
    }


    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseImg() {
        return courseImg;
    }

    public void setCourseImg(String courseImg) {
        this.courseImg = courseImg;
    }

    public String getCourseMode() {
        return courseMode;
    }

    public void setCourseMode(String courseMode) {
        this.courseMode = courseMode;
    }

    public String getCourseTracks() {
        return courseTracks;
    }

    public void setCourseTracks(String courseTracks) {
        this.courseTracks = courseTracks;
    }
}
