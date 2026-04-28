package com.luigipioarianocompany.elearning.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;

@Entity
@Table
@Data
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "Inserire la data di assunzione")
    private LocalDate data_di_assunzione;

    @Column(nullable = false)
    @NotNull(message = "Inserire il salario")
    private Float salario;

    @Column(nullable = false)
    @NotBlank(message = "Inserire titolo di studi")
    private String titolo;

    @Column(nullable = false)
    @NotNull(message = "Inserire la votazione")
    private Integer votazione;






    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            joinColumns =  @JoinColumn(name = "docente_id"),
            inverseJoinColumns = @JoinColumn(name = "esame_id")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Esame> esami;

    @OneToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Account account;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "anagrafica_id")
    private Anagrafica anagrafica;

}
