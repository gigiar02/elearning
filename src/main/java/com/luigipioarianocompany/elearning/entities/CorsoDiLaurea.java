package com.luigipioarianocompany.elearning.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;

@Entity
@Table
@Data
public class CorsoDiLaurea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Inserire il nome")
    private String nome;


    @OneToMany(mappedBy = "corsoDiLaurea",fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Esame> esami;

    @ManyToMany(mappedBy = "corsiDiLaurea")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Studente> studenti;


}
