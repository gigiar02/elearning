package com.luigipioarianocompany.elearning.entities;
import com.luigipioarianocompany.elearning.utility.Utility;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import com.luigipioarianocompany.elearning.utility.Utility.Ruolo;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.lang.annotation.Documented;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

/*
    Account:

*/
@Entity
@Data
@Table
public class Account implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    @NotBlank(message = "Inserire il nome!")
    private String nome;


    @Column(nullable = false)
    @NotBlank(message = "Inserire il cognome")
    private String cognome;


    @Column(nullable = false)
    @NotNull(message = "Inserire la data di nascita")
    private LocalDate data_di_nascita;


    @Column(nullable = false,unique = true)
    @NotBlank(message = "Inserire l'email")
    private String email;


    @Column(nullable = false)
    @NotBlank(message = "Inserire la password")
    private String password ;


    @Column(nullable = false)
    @NotBlank(message = "Inserire il numero di telefono")
    private String telefono;


    @Column(nullable = false)
    @NotNull(message = "Inserire il tipo di ruolo ricoperto")
    @Enumerated(EnumType.STRING)
    private Ruolo tipoRuolo;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "account")
    @JoinColumn(name = "docente_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Docente docente;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "account")
    @JoinColumn(name = "docente_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Studente studente;




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String role = "ROLE_" + tipoRuolo.name();
        return  List.of(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getUsername() {
        return "";
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
