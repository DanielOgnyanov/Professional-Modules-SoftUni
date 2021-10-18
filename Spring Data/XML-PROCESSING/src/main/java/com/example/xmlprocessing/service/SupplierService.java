package com.example.xmlprocessing.service;

import com.example.xmlprocessing.domain.dtos.SupplierDto;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface SupplierService {
    void seedSupplier() throws JAXBException, FileNotFoundException;
    SupplierDto getRandomSupplier();
}
