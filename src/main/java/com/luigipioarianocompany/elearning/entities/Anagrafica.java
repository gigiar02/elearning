package com.luigipioarianocompany.elearning.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table
@Data
public class Anagrafica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    @NotBlank(message = "Inserire il nome!")
    private String nome;


    @Column(nullable = false)
    @NotBlank(message = "Inserire il cognome")
    private String cognome;


    @Column(nullable = false)
    @NotNull(message = "Inserire la data di nascita")
    private LocalDate data_di_nascita;

    @Column(nullable = false)
    @NotBlank(message = "Inserire il numero di telefono")
    private String telefono;

    @Column(nullable = false)
    @NotBlank(message = "Inserire il codice fiscale")
    private String codiceFiscale;

    @Column(nullable = false)
    @NotBlank(message = "Inserire la residenza")
    private String residenza;

    @Column(nullable = false)
    @NotBlank(message = "Inserire la nazionalità")
    private String nazionalità;

    @OneToOne(mappedBy = "anagrafica")
    private Studente studente;

    @OneToOne(mappedBy = "anagrafica")
    private Docente docente;
}
