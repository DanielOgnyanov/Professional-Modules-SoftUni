package com.example.music_db_project.service.Impl;

import com.example.music_db_project.models.entities.Album;
import com.example.music_db_project.models.view.AlbumViewModel;
import com.example.music_db_project.security.CurrentUser;
import com.example.music_db_project.models.service.AlbumServiceModel;
import com.example.music_db_project.repository.AlbumRepository;
import com.example.music_db_project.service.AlbumService;
import com.example.music_db_project.service.ArtistService;
import com.example.music_db_project.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {


    private final AlbumRepository albumRepository;
    private final ModelMapper modelMapper;
    private final ArtistService artistService;
    private final CurrentUser currentUser;
    private final UserService userService;

    public AlbumServiceImpl(AlbumRepository albumRepository, ModelMapper modelMapper, ArtistService artistService, CurrentUser currentUser, UserService userService) {
        this.albumRepository = albumRepository;
        this.modelMapper = modelMapper;
        this.artistService = artistService;
        this.currentUser = currentUser;
        this.userService = userService;
    }


    @Override
    public void add(AlbumServiceModel albumServiceModel) {

        Album album = modelMapper.map(albumServiceModel, Album.class);

        album.setGenre(albumServiceModel.getGenre());

        album.setArtist(artistService.findByName(albumServiceModel.getArtist()));

        album.setAddedFrom(userService.findById(currentUser.getId()));

        albumRepository.save(album);
    }

    @Override
    public BigDecimal findAllSoldCopies() {
        return albumRepository.allSoldCopies();
    }

    @Override
    public List<AlbumServiceModel> getAllOrdered() {
        return albumRepository.findAllOrdered()
                .stream().map(album -> modelMapper.map(album, AlbumServiceModel.class))
                .collect(Collectors.toList());
    }
}
