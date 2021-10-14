package com.example.music_db_project.web;

import com.example.music_db_project.security.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CurrentUser currentUser;

    public HomeController(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }


    @GetMapping("/")
    public String index(Model model) {
        if (currentUser.isAnonymous()) {
            return "index";
        }
        return "home";


    }
}
