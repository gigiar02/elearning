package com.luigipioarianocompany.elearning.services;

import com.luigipioarianocompany.elearning.entities.Account;
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
}
