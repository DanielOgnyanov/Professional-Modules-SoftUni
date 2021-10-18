package com.example.xmlprocessing.service.Imp;


import com.example.xmlprocessing.domain.dtos.PartDto;
import com.example.xmlprocessing.domain.dtos.PartRootDto;
import com.example.xmlprocessing.domain.entities.Part;
import com.example.xmlprocessing.repositories.PartRepository;
import com.example.xmlprocessing.service.PartService;
import com.example.xmlprocessing.service.SupplierService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PartServiceImp implements PartService {



    private final PartRepository partRepository;
    private final ModelMapper modelMapper;
    private final SupplierService supplierService;


    @Autowired
    public PartServiceImp(PartRepository partRepository, ModelMapper modelMapper, SupplierService supplierService) {
        this.partRepository = partRepository;
        this.modelMapper = modelMapper;
        this.supplierService = supplierService;

    }


    @Override
    public void seedParts() throws JAXBException, FileNotFoundException {

        JAXBContext context = JAXBContext.newInstance(PartRootDto.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();

        String path = "C:\\Users\\Proprietario\\IdeaProjects\\XML-PROCESSING\\src\\main\\resources\\xmls\\parts.xml";

        BufferedReader reader = new BufferedReader(new FileReader(new File(path)));

        PartRootDto list = (PartRootDto) unmarshaller.unmarshal(reader);

        System.out.println();

        for (PartDto partDto : list.getPartDtos()) {
            partDto.setSupplierDto(this.supplierService.getRandomSupplier());
            this.partRepository.saveAndFlush(this.modelMapper.map(partDto, Part.class));
        }



    }

    @Override
    public List<PartDto> getRandomParts() {

        List<PartDto> partDtos = new ArrayList<>();

        Random random = new Random();

        int size = random.nextInt(10) + 10;

        for (int i = 0; i < size; i++) {

            int id = random.nextInt((int) (this.partRepository.count()) - 1 ) + 1;

            PartDto part = this.modelMapper.map(this.partRepository.getOne((long) id),PartDto.class);
            part.setSupplierDto(this.supplierService.getRandomSupplier());

            partDtos.add(part);
        }


        return partDtos;
    }


}
