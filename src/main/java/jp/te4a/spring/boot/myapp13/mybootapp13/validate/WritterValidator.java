package jp.te4a.spring.boot.myapp13.mybootapp13.validate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class WritterValidator implements ConstraintValidator<Writter,String>{
        String okValue;
        @Override
        public void initialize(Writter constraintAnnotation){ 
            this.okValue =  constraintAnnotation.ok(); }
            @Override
            public boolean isValid(String value, ConstraintValidatorContext context) {
                if (value == null) {
                    return true; // @NotNull アノテーションを使っていればここで null チェックは不要
                }
                if (!value.equals(okValue)) {
                    return false;
                }
                return true;
            }
}
    
