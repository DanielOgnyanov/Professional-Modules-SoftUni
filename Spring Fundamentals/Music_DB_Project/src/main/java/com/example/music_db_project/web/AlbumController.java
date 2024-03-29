package com.example.music_db_project.web;

import com.example.music_db_project.models.biding.AlbumBindingModel;
import com.example.music_db_project.security.CurrentUser;
import com.example.music_db_project.models.service.AlbumServiceModel;
import com.example.music_db_project.service.AlbumService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/albums")
public class AlbumController {

    private final AlbumService albumService;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public AlbumController(AlbumService albumService, ModelMapper modelMapper, CurrentUser currentUser) {
        this.albumService = albumService;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }


    @GetMapping("/add-album")
    public String add(Model model) {

        if (currentUser.isAnonymous()) {
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

        albumService.add(modelMapper.map(albumBindingModel, AlbumServiceModel.class));


        return "redirect:/";

    }


    @GetMapping("/delete/{id}")
    public String buyById(@PathVariable Long id) {

        if (currentUser.isAnonymous()) {
            return "redirect:/login";
        }

        albumService.deleteById(id);

        return "redirect:/";

    }
}
