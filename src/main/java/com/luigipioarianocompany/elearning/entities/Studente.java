package com.luigipioarianocompany.elearning.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table
@Data
public class Studente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "Inserire la data di immatricolazione")
    private LocalDate data_immatricolazione;

    @Column(nullable = false, unique = true)
    @NotNull(message = "Inserire la matricola")
    private String matricola;

    @ManyToMany()
    @JoinTable(
            joinColumns = @JoinColumn(name = "studente_id"),
            inverseJoinColumns = @JoinColumn(name = "corso_id")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<CorsoDiLaurea> corsiDiLaurea;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

}
