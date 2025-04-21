package com.texas.bcasixthtexas.helpers;

public class StudentModel {
    int rollNo;
    String firstName;
    String lastName;
    String course;
    int year;
    CourseModel courseModel;

    public StudentModel(int rollNo, String firstName, String lastName, String course, int year, CourseModel courseModel) {
        this.rollNo = rollNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
        this.year = year;
        this.courseModel = courseModel;
    }
}
