package com.example.demo1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo1.Model.Course;
import com.example.demo1.Service.CourseService;

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
    public String create(Course newCourse, Model model) {
        courseService.add(newCourse);
        return "redirect:/home";
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, Model model) {
        Course course = courseService.getCourseById(id);
        if (course != null) {
            model.addAttribute("course", course);
            return "update";
        } else {
            return "redirect:/home";
        }
    }

    @PostMapping("/update")
    public String update(Course updatedCourse, Model model) {
        courseService.update(updatedCourse);
        return "redirect:/home";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        courseService.delete(id);
        return "redirect:/home";
    }
}

