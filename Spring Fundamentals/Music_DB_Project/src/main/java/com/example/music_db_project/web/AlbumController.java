package com.example.music_db_project.web;

import com.example.music_db_project.models.biding.AlbumBindingModel;
import com.example.music_db_project.service.AlbumService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/albums")
public class AlbumController {

    private final AlbumService albumService;
    private final ModelMapper modelMapper;

    public AlbumController(AlbumService albumService, ModelMapper modelMapper) {
        this.albumService = albumService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/add-album")
    public String add(Model model, HttpSession httpSession) {

        if (httpSession.getAttribute("user") == null) {
            return "redirect:/login";
        }

        if (!model.containsAttribute("albumBindingModel")) {
            model.addAttribute("albumBindingModel", new AlbumBindingModel());
        }
        return "add-album";
    }


    @PostMapping("/add-album")
    public String addConfirm(@Valid AlbumBindingModel albumBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {


        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("albumBindingModel", albumBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.albumBindingModel", bindingResult);

            return "redirect:add-album";

        }




        return "redirect:/";

    }
}
