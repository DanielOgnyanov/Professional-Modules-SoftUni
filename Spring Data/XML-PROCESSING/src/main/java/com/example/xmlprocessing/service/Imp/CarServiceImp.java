package com.example.xmlprocessing.service.Imp;

import com.example.xmlprocessing.domain.dtos.CarDto;
import com.example.xmlprocessing.domain.dtos.CarRootDto;
import com.example.xmlprocessing.domain.entities.Car;
import com.example.xmlprocessing.repositories.CarRepository;
import com.example.xmlprocessing.service.CarService;
import com.example.xmlprocessing.service.PartService;
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

@Service
public class CarServiceImp implements CarService {


    private final CarRepository carRepository;
    private final PartService partService;
    private final ModelMapper modelMapper;

    @Autowired
    public CarServiceImp(CarRepository carRepository, PartService partService, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.partService = partService;
        this.modelMapper = modelMapper;
    }


    @Override
    public void seedCars() throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(CarRootDto.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();

        String path = "C:\\Users\\Proprietario\\IdeaProjects\\XML-PROCESSING\\src\\main\\resources\\xmls\\cars.xml";

        BufferedReader reader = new BufferedReader(new FileReader(new File(path)));

        CarRootDto list = (CarRootDto) unmarshaller.unmarshal(reader);

        for (CarDto carDto :  list.getCarDtoList()) {
            carDto.setParts(this.partService.getRandomParts());

            this.carRepository.saveAndFlush(this.modelMapper.map(carDto, Car.class));
        }
    }
}
