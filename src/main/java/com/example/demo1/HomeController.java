package com.example.demo1;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/index.html")
    public String Index(){
        return "index.html";
    }
    @GetMapping("/contact.html")
    public String Contact(){
        return "contact.html";
    }
    @GetMapping("/About.html")
    public String About(){
        return "About.html";
    }
    @GetMapping("/program.html")
    public String Program(){
        return "program.html";
    }

}
