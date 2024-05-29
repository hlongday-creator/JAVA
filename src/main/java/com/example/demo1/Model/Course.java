package com.example.demo1.Model;

import java.time.LocalDate;

public class Course {
    private int id;
    private String lectureName;
    private String place;
    private LocalDate startDate;

    // Constructor
    public Course() {
        this.id = id;
        this.lectureName = lectureName;
        this.place = place;
        this.startDate = startDate;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getLectureName() {
        return lectureName;
    }

    public String getPlace() {
        return place;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}
