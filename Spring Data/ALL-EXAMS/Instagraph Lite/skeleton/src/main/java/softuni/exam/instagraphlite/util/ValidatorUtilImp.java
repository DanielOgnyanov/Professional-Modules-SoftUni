package softuni.exam.instagraphlite.util;


import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Validator;

public class ValidatorUtilImp implements ValidatorUtil{
    private final Validator validator;


    @Autowired
    public ValidatorUtilImp(Validator validator) {      /////////////////////////////////////
        this.validator = validator;
    }


    @Override
    public <T> boolean isValid(T entity) {
        return this.validator.validate(entity).isEmpty();
    }
}
