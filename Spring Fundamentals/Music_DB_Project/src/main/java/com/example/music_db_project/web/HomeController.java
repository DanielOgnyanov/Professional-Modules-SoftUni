package com.example.music_db_project.web;

import com.example.music_db_project.models.view.AlbumViewModel;
import com.example.music_db_project.security.CurrentUser;
import com.example.music_db_project.service.AlbumService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.stream.Collectors;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final AlbumService albumService;
    private final ModelMapper modelMapper;

    public HomeController(CurrentUser currentUser, AlbumService albumService, ModelMapper modelMapper) {
        this.currentUser = currentUser;
        this.albumService = albumService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/")
    public String index(Model model) {
        if (currentUser.isAnonymous()) {
            return "index";
        }

        model.addAttribute("totalSoldCopies", albumService.findAllSoldCopies());
        model.addAttribute("albums", albumService.getAllOrdered().stream()
                .map(a -> modelMapper
                        .map(a, AlbumViewModel.class)).collect(Collectors.toList()));
        return "home";


    }
}
