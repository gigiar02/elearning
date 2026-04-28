package com.luigipioarianocompany.elearning.services;

import com.luigipioarianocompany.elearning.dto.DocenteDTO;
import com.luigipioarianocompany.elearning.entities.Docente;
import com.luigipioarianocompany.elearning.entities.Esame;
import com.luigipioarianocompany.elearning.repositories.DocenteRepository;
import com.luigipioarianocompany.elearning.repositories.EsameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

import static com.luigipioarianocompany.elearning.utility.Utility.docenteToDTO;

@Service
public class DocenteService {
    @Autowired
    private EsameRepository esameRepository;

    @Autowired
    private DocenteRepository docenteRepository;


    public DocenteService(EsameRepository esameRepository,DocenteRepository docenteRepository) {}

    public Set<Esame> GetEsami(Docente docente) {
        return esameRepository.findByDocenti(docente);
    }


    public DocenteDTO getDocenteDTO(Docente docente) {
        DocenteDTO dto = docenteToDTO(docente,GetEsami(docente));
        return dto;
    }

    public void caricaAnagrafica(DocenteDTO docenteDTO) {
        System.out.println("caricaAnagrafica : " + docenteRepository.findAnagraficaByDocenteId(docenteDTO.getDocente().getId()));
        docenteDTO.setAnagrafica(docenteRepository.findAnagraficaByDocenteId(docenteDTO.getDocente().getId()));
    }


}
