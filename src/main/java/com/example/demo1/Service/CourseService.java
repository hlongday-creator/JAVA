package com.example.demo1.Service;

import com.example.demo1.Model.Course;
import com.example.demo1.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course add(Course newCourse) {
        return courseRepository.save(newCourse);
    }

    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    public Optional<Course> getById(int id) {
        return courseRepository.findById(id);
    }

    public Course update(Course updatedCourse) {
        Course existingCourse = courseRepository.findById(updatedCourse.getId())
                .orElseThrow(() -> new IllegalStateException("Course with ID " +
                        updatedCourse.getId() + " does not exist."));

        // Update the fields of the existing course
        existingCourse.setLectureName(updatedCourse.getLectureName());
        existingCourse.setPlace(updatedCourse.getPlace());
        existingCourse.setStartDate(updatedCourse.getStartDate());

        return courseRepository.save(existingCourse);
    }

    public void delete(int id) {
        if (!courseRepository.existsById(id)) {
            throw new IllegalStateException("Course with ID " + id + " does not exist.");
        }
        courseRepository.deleteById(id);
    }
    public List<Course> search(String keyword) {
        return courseRepository.findByLectureNameContaining(keyword);
    }
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

}
