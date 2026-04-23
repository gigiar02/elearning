package com.luigipioarianocompany.elearning.dto;

import com.luigipioarianocompany.elearning.entities.Docente;
import com.luigipioarianocompany.elearning.entities.Studente;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.executable.ExecutableValidator;
import jakarta.validation.metadata.BeanDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.SmartValidator;
import org.springframework.validation.Validator;

import java.util.Set;

@Component
public class AccountDTOValidator implements Validator {
    @Autowired
    SmartValidator validator;


    @Override
    public boolean supports(Class<?> clazz) {
        return AccountDTO.class.equals(clazz);
    }

    //In base al ruolo dell'account(STUDENTE,DOCENTE) voglio validare solo uno dei due
    @Override
    public void validate(Object target, Errors errors) {
        AccountDTO dto = (AccountDTO) target;

        //Validazione Account da fare sempre
        errors.pushNestedPath("account");
        validator.validate(dto.getAccount(),errors);
        errors.popNestedPath();

        //l' utente non ha scelto il ruolo
        if(dto.getAccount().getTipoRuolo()==null) return;

        //Validazione Docente o Studente
        switch (dto.getAccount().getTipoRuolo()){
            case STUDENTE -> {
                errors.pushNestedPath("studente");
                if(dto.getStudente() == null){dto.setStudente(new Studente());}
                validator.validate(dto.getStudente(),errors);
                errors.popNestedPath();
            }

            case DOCENTE -> {
                errors.pushNestedPath("docente");
                if(dto.getDocente() == null){dto.setDocente(new Docente());}
                validator.validate(dto.getDocente(),errors);
                errors.popNestedPath();
            }

            default -> {}//Admin
        }
    }
}
