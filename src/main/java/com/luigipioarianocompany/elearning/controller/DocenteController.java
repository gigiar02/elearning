package com.luigipioarianocompany.elearning.controller;

import com.luigipioarianocompany.elearning.dto.DocenteDTO;
import com.luigipioarianocompany.elearning.entities.Account;
import com.luigipioarianocompany.elearning.services.DocenteService;
import io.micrometer.observation.Observation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import static com.luigipioarianocompany.elearning.utility.Utility.docenteToDTO;

@Controller
public class DocenteController {
    @Autowired
    DocenteService docenteService;

    public DocenteController(DocenteService docenteService) {}


    @GetMapping("/docente/home")
    public String homeDocente(@AuthenticationPrincipal Account account,Model model) {
        //DTO contiene il docente e la lista dei suoi esami
        DocenteDTO dto = docenteService.getDocenteDTO(account.getDocente());
        docenteService.caricaAnagrafica(dto);
        System.out.println(dto.getAnagrafica());
        model.addAttribute("dto", dto);
        return "docente/docente_home";
    }

    @GetMapping("/docente/gestisciGruppo/{id}")
    public String GestisciGruppo(@AuthenticationPrincipal Account account, @PathVariable("id") Integer id, Model model) {

        System.out.println("Gestisci gruppo: " + docenteService.GetEsami(account.getDocente()));

        return "docente/docente_gestisci_gruppo";
    }


}
