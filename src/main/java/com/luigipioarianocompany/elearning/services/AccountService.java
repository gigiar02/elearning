package com.luigipioarianocompany.elearning.services;

import com.luigipioarianocompany.elearning.dto.AccountDTO;
import com.luigipioarianocompany.elearning.entities.Account;
import com.luigipioarianocompany.elearning.entities.Docente;
import com.luigipioarianocompany.elearning.entities.Studente;
import com.luigipioarianocompany.elearning.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    private AccountRepository repo;

    public AccountService(AccountRepository repo) {
        this.repo = repo;
    }

    public Optional<Account> findByEmail(String email){
        return repo.findByEmail(email);
    }

    //Salva un account a db
    public Account registraAccount(AccountDTO dto){
        Account account = dto.getAccount();

        //Studente / Docente / Admin
        switch(account.getTipoRuolo()){

            case STUDENTE -> {
                account.setStudente(dto.getStudente());
                Studente studente = dto.getStudente();
                studente.setAccount(account);
            }

            case DOCENTE ->  {
                account.setDocente(dto.getDocente());
                Docente docente = dto.getDocente();
                docente.setAccount(account);
            }

        }

        return this.save(account);
    }

    public Account save(Account account){
        return this.repo.save(account);
    }
}
