package uel.ati.mercado.model;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<Email, String> {

    @Override
    public void initialize(Email email) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.length() == 0) {
            return true;
        }
        if(!value.endsWith("@uel.br")){
            return false;
        }
        return true;
    }
}
