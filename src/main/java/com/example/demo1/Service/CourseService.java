package com.example.demo1.Service;

import com.example.demo1.Model.Course;
import com.example.demo1.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public void add(Course newCourse) {
        courseRepository.save(newCourse);
    }

    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Integer id) {
        return courseRepository.findById(id).orElse(null);
    }

    public void update(Course updatedCourse) {
        if (courseRepository.existsById(updatedCourse.getId())) {
            courseRepository.save(updatedCourse);
        }
    }

    public void delete(Integer id) {
        courseRepository.deleteById(id);
    }

}