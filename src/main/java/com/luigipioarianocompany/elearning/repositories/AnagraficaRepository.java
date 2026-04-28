package com.luigipioarianocompany.elearning.repositories;

import com.luigipioarianocompany.elearning.entities.Anagrafica;
import com.luigipioarianocompany.elearning.entities.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AnagraficaRepository extends JpaRepository<Anagrafica,Integer> {
    public Anagrafica findByDocente(Docente docente);

}
