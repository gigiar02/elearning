package com.luigipioarianocompany.elearning.repositories;

import com.luigipioarianocompany.elearning.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer>{

    /**
     * Ricerca un account tramite email
     *
     * @param email Email dell'account
     * @return Account se lo trova altrimenti null
     */
    Optional<Account> findByEmail(String email);
}
