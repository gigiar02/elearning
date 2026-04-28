package com.luigipioarianocompany.elearning.repositories;

import com.luigipioarianocompany.elearning.entities.Account;
import com.luigipioarianocompany.elearning.entities.Docente;
import com.luigipioarianocompany.elearning.entities.Esame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface EsameRepository extends JpaRepository<Esame,Integer>{


    Set<Esame> findByDocenti(Docente docente);

}
