package com.example.xmlprocessing.service.Imp;

import com.example.xmlprocessing.domain.dtos.PartRootDto;
import com.example.xmlprocessing.domain.dtos.SupplierDto;
import com.example.xmlprocessing.domain.dtos.SupplierRootDto;
import com.example.xmlprocessing.domain.entities.Supplier;
import com.example.xmlprocessing.repositories.SupplierRepository;
import com.example.xmlprocessing.service.SupplierService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.Optional;
import java.util.Random;

@Service
@Transactional
public class SupplierServiceImp implements SupplierService {


    private final SupplierRepository supplierRepository;
    private final ModelMapper modelMapper;



    @Autowired
    public SupplierServiceImp(SupplierRepository supplierRepository, ModelMapper modelMapper) {
        this.supplierRepository = supplierRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedSupplier() throws JAXBException, FileNotFoundException {


        JAXBContext context = JAXBContext.newInstance(SupplierRootDto.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();

        String path = "C:\\Users\\Proprietario\\IdeaProjects\\XML-PROCESSING\\src\\main\\resources\\xmls\\suppliers.xml";

        BufferedReader reader = new BufferedReader(new FileReader(new File(path)));

        SupplierRootDto list = (SupplierRootDto) unmarshaller.unmarshal(reader);

        for (SupplierDto supplierDto :  list.getSupplierDtos()) {
            this.supplierRepository
                    .saveAndFlush(this.modelMapper.map(supplierDto, Supplier.class));
            System.out.println();
        }

    }

    @Override
    public SupplierDto getRandomSupplier() {
        Random random = new Random();

        int id = random.nextInt((int) (this.supplierRepository.count()) - 1) + 1;

        Supplier supplier = this.supplierRepository.getOne((long) id);

        return this.modelMapper
                .map(supplier, SupplierDto.class);
    }
}
