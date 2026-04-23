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
public class Esame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "")
    private String nome;


    @ManyToMany(mappedBy = "esami")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Docente> docenti;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="corso_id",nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private CorsoDiLaurea corsoDiLaurea;



}
