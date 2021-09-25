package com.example.jsonprocessing.services.Imp;

import com.example.jsonprocessing.domain.dtos.SupplierSeedDto;
import com.example.jsonprocessing.domain.entities.Supplier;
import com.example.jsonprocessing.domain.repositories.SupplierRepositories;
import com.example.jsonprocessing.services.SupplierService;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


@Service

public class SupplierServiceImp implements SupplierService {

    private final static String SUPPLIER_PATH = "src/main/resources/jsons/suppliers.json";
    private final SupplierRepositories supplierRepositories;
    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public SupplierServiceImp(SupplierRepositories supplierRepositories, ModelMapper modelMapper, Gson gson) {
        this.supplierRepositories = supplierRepositories;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }


    @Override
    public void seedSuppliers() throws IOException {

        String content =
                String.join("", Files.readAllLines(Path.of("src/main/resources/jsons/suppliers.json")));


        SupplierSeedDto[] supplierSeedDtos = this.gson.fromJson(content, SupplierSeedDto[].class);

        for (SupplierSeedDto supplierSeedDto : supplierSeedDtos) {
            Supplier map = this.modelMapper.map(supplierSeedDto, Supplier.class);

            this.supplierRepositories.saveAllAndFlush(map);
        }

    }

}

