package com.luigipioarianocompany.elearning.dto;

import com.luigipioarianocompany.elearning.entities.Docente;
import com.luigipioarianocompany.elearning.entities.Esame;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;


@Data
public class DocenteDTO {

    private Docente docente;
    private Set<Esame> esami;

    public DocenteDTO(Docente docente) {this.docente = docente; esami = docente.getEsami(); }
}
