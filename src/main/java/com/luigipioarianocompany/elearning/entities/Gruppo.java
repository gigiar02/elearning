package com.luigipioarianocompany.elearning.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Gruppo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
