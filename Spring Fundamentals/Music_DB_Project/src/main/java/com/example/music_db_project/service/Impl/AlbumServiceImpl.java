package com.example.music_db_project.service.Impl;

import com.example.music_db_project.models.entities.Album;
import com.example.music_db_project.models.entities.Artist;
import com.example.music_db_project.models.service.AlbumServiceModel;
import com.example.music_db_project.repository.AlbumRepository;
import com.example.music_db_project.service.AlbumService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AlbumServiceImpl implements AlbumService {


    private final AlbumRepository albumRepository;
    private final ModelMapper modelMapper;

    public AlbumServiceImpl(AlbumRepository albumRepository, ModelMapper modelMapper) {
        this.albumRepository = albumRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void add(AlbumServiceModel albumServiceModel) {

        Album album = modelMapper.map(albumServiceModel, Album.class);

        album.setGenre(albumServiceModel.getGenre());

        album.setArtist();
    }
}
