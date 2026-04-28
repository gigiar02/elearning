package com.luigipioarianocompany.elearning.repositories;

import com.luigipioarianocompany.elearning.entities.Anagrafica;
import com.luigipioarianocompany.elearning.entities.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DocenteRepository extends JpaRepository<Docente,Integer> {
    @Query("SELECT d.anagrafica FROM Docente d WHERE d.id = :id")
    Anagrafica findAnagraficaByDocenteId(@Param("id") Long id);}
