package com.example.xmlprocessing.web.controllers;

import com.example.xmlprocessing.service.CarService;
import com.example.xmlprocessing.service.PartService;
import com.example.xmlprocessing.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class CarDealerController implements CommandLineRunner {

    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;

    @Autowired
    public CarDealerController(SupplierService supplierService, PartService partService, CarService carService) {
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
    }


    @Override
    public void run(String... args) throws Exception {


         this.supplierService.seedSupplier();

         this.partService.seedParts();

         this.carService.seedCars();
    }
}
