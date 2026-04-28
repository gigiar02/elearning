package com.luigipioarianocompany.elearning.controller;

import com.luigipioarianocompany.elearning.dto.AccountDTO;
import com.luigipioarianocompany.elearning.dto.AccountDTOValidator;
import com.luigipioarianocompany.elearning.entities.Account;
import com.luigipioarianocompany.elearning.entities.Docente;
import com.luigipioarianocompany.elearning.entities.Studente;
import com.luigipioarianocompany.elearning.repositories.AccountRepository;
import com.luigipioarianocompany.elearning.services.AccountService;
import com.luigipioarianocompany.elearning.utility.Utility;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Si occupa della gestione delle pagine associate all'account
 */
@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountDTOValidator validator;


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(validator);
    }

    //LOGIN
    @GetMapping("/")
    public String instrada(){
        return "login";
    }

    //HOME ADMIN
    @GetMapping("/admin/home")
    public String admin_home(){
        System.out.println("admin_home");
        return "admin/home";

    }

    //FORM INSERIMENTO FIGURA
    @GetMapping("/admin/form")
    public String admin_form(Model model){
        AccountDTO dto = new AccountDTO(new Account(),new Docente(),new Studente());
        model.addAttribute("dto",dto);
        return "admin/admin_form";
    }

    @PostMapping("/admin/inserimento")
    public String inserimento(@ModelAttribute("dto") AccountDTO dto, BindingResult result, Model model)
    {
        validator.validate(dto,result);
        if(result.hasErrors())
        {
            System.out.println("Errore " + result.getAllErrors());
            return "admin/admin_form";
        }

        Account acc = accountService.registraAccount(dto);
        System.out.println("Registrazione: " + acc);
        return "admin/home";
    }



}
