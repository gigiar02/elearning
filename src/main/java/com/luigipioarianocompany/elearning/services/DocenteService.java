package com.luigipioarianocompany.elearning.services;

import com.luigipioarianocompany.elearning.entities.Docente;
import com.luigipioarianocompany.elearning.entities.Esame;
import com.luigipioarianocompany.elearning.repositories.EsameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class DocenteService {
    @Autowired
    private EsameRepository esameRepository;

    public DocenteService(EsameRepository esameRepository) {}

    public Set<Esame> GetEsami(Docente docente) {
        return esameRepository.findByDocenti(docente);
    }


}
