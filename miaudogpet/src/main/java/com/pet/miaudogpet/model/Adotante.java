package com.miauadopt.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "adotantes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Adotante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false)
    private String nome;
    
    @Column(length = 15)
    private String telefone;
    
    @Column(nullable = false)
    private String email;
}