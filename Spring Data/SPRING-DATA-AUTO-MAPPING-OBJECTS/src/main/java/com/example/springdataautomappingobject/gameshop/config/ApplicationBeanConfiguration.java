package com.example.springdataautomappingobject.gameshop.config;


import com.example.springdataautomappingobject.gameshop.util.ValidatorUtil;
import com.example.springdataautomappingobject.gameshop.util.ValidatorUtilImp;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean

    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


    @Bean
    public Validator validator() {
        return Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Bean
    public ValidatorUtil validatorUtil() {
        return new ValidatorUtilImp(validator());
    }
}
