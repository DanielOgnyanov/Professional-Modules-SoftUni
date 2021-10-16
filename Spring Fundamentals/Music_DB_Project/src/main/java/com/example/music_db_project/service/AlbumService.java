package com.example.music_db_project.service;

import com.example.music_db_project.models.service.AlbumServiceModel;
import com.example.music_db_project.models.view.AlbumViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface AlbumService {
    void add(AlbumServiceModel albumServiceModel);

    BigDecimal findAllSoldCopies();

    List<AlbumServiceModel> getAllOrdered();

    void deleteById(Long id);
}
