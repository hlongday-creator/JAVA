package com.example.demo1.Service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo1.Model.Course;

@Service
public class CourseService {
    private List<Course> listCourse = new ArrayList<>();

    public void add(Course newCourse) {
        listCourse.add(newCourse);
    }

    public List<Course> getAll() {
        return listCourse;
    }
}

