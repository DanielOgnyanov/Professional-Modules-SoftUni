package com.example.xmlprocessing.service;

import com.example.xmlprocessing.domain.dtos.PartDto;
import com.example.xmlprocessing.domain.dtos.SupplierDto;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.List;

public interface PartService {

    void seedParts() throws JAXBException, FileNotFoundException;

    List<PartDto> getRandomParts();
}
