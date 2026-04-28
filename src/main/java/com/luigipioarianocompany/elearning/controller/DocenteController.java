package com.luigipioarianocompany.elearning.controller;

import com.luigipioarianocompany.elearning.dto.DocenteDTO;
import com.luigipioarianocompany.elearning.entities.Account;
import com.luigipioarianocompany.elearning.entities.Docente;
import com.luigipioarianocompany.elearning.services.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DocenteController {
    @Autowired
    DocenteService docenteService;

    public DocenteController(DocenteService docenteService) {}


    @GetMapping("/docente/home")
    public String homeDocente(@AuthenticationPrincipal Account account,Model model) {

        System.out.println("Gestisci gruppo: " + docenteService.GetEsamis(account.getDocente()));
        return "docente/docente_home";
    }

    @GetMapping("/docente/gestisciGruppo/{id}")
    public String GestisciGruppo(@AuthenticationPrincipal Account account, @PathVariable("id") Integer id, Model model) {

        System.out.println("Gestisci gruppo: " + docenteService.GetEsamis(account.getDocente()));
        return "docente/docente_gestisci_gruppo";
    }


}
