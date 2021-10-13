package com.example.music_db_project.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/albums")
public class AlbumController {


    @GetMapping("/add-album")
    public String add(Model model, HttpSession httpSession) {

        if (httpSession.getAttribute("user") == null) {
            return "redirect:/login";
        }

        if (!model.containsAttribute("orderBindingModel")) {
            model.addAttribute("orderBindingModel", );
        }
        return "add-album";
    }
}
