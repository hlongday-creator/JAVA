package com.example.demo1.Controller;

import com.example.demo1.Model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.Arrays;

@Controller
public class PersonController {
    @GetMapping("/person")
    public String index(Model model) {
        model.addAttribute("info", "<b>Thông tin </b> </br>");
        Person p = new Person();
        p.setName("Thymeleaf Spring Boot");
        p.setAge(36);
        p.setSex(1);
        p.setMarried(true);
        p.setCreateTime(LocalDate.now());
        p.setLanguage(Arrays.asList("Java", "C#", "Python"));
        model.addAttribute("person", p);
        return "person"; // Chỉ trả về tên view, Spring Boot sẽ tự động tìm file person.html trong thư mục template
    }
}
