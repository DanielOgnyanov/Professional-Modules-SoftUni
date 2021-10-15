package com.example.music_db_project.web;

import com.example.music_db_project.security.CurrentUser;
import com.example.music_db_project.service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final AlbumService albumService;

    public HomeController(CurrentUser currentUser, AlbumService albumService) {
        this.currentUser = currentUser;
        this.albumService = albumService;
    }


    @GetMapping("/")
    public String index(Model model) {
        if (currentUser.isAnonymous()) {
            return "index";
        }

        model.addAttribute("totalSoldCopies", albumService.findAllSoldCopies());
        return "home";


    }
}
