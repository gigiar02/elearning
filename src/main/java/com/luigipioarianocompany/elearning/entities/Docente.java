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


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            joinColumns =  @JoinColumn(name = "esame_id"),
            inverseJoinColumns = @JoinColumn(name = "docente_id")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Esame> esami;

    @OneToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Account account;

}
