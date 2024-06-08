package com.example.demo1.Controller;

import com.example.demo1.Model.Course;
import com.example.demo1.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("course", new Course());
        return "create";
    }

    @PostMapping("/create")
    public String create(Course newCourse) {
        courseService.add(newCourse);
        return "redirect:/course/home";
    }

    @GetMapping("/update/{id}")
    public String showEditCourseForm(@PathVariable("id") int id, Model model) {
        Optional<Course> course = courseService.getById(id);
        if (course.isPresent()) {
            model.addAttribute("course", course.get());
            return "update";
        } else {
            return "redirect:/course/home";
        }
    }

    @PostMapping("/update")
    public String updateCourse(@ModelAttribute("course") Course course) {
        courseService.update(course);
        return "redirect:/course/home";
    }

    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable("id") int id) {
        courseService.delete(id);
        return "redirect:/course/home";
    }

    @GetMapping("/home")
    public String home(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        List<Course> courses;
        if (keyword != null && !keyword.isEmpty()) {
            courses = courseService.search(keyword);
        } else {
            courses = courseService.getAllCourses();
        }
        model.addAttribute("listcourse", courses);
        return "home";
    }
}
