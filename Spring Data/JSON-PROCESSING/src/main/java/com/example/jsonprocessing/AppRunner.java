package com.example.jsonprocessing;

import com.example.jsonprocessing.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    private final SupplierService supplierService;

    @Autowired
    public AppRunner(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.supplierService.seedSuppliers();
    }
}
