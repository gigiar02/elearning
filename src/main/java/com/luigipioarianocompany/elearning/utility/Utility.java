package com.luigipioarianocompany.elearning.utility;
/*
    Classe di utilità
 */

import com.luigipioarianocompany.elearning.dto.DocenteDTO;
import com.luigipioarianocompany.elearning.entities.Docente;
import com.luigipioarianocompany.elearning.entities.Esame;

import java.util.Set;

public class Utility {

    //Ruoli
    public enum Ruolo{
        ADMIN,
        STUDENTE,
        DOCENTE
    }

    //Nazionalità
    public enum Nazionalità{
        ITALIA,
        FRANCIA,
        RUSSIA
    }

    public static DocenteDTO docenteToDTO(Docente docente, Set<Esame> esami){
        DocenteDTO docenteDTO = new DocenteDTO(docente);
        docenteDTO.setEsami(esami);
        return docenteDTO;
    }

}
