package com.luigipioarianocompany.elearning.dto;

import com.luigipioarianocompany.elearning.entities.Account;
import com.luigipioarianocompany.elearning.entities.Docente;
import com.luigipioarianocompany.elearning.entities.Studente;
import jakarta.validation.Valid;
import lombok.Data;

@Data
public class AccountDTO {

    Account account;
    Docente docente;
    Studente studente;

    public AccountDTO(Account account, Docente docente, Studente studente) {
        this.account = account;
        this.docente = docente;
        this.studente = studente;
    }

    public AccountDTO(Account account) {
        this.account = account;
    }

    public AccountDTO() {}
}
