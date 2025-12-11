package com.miauadopt.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "login")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false)
    private String usuario;
    
    @Column(nullable = false)
    private String email;
    
    @Column(length = 15)
    private String telefone;
    
    @Column(nullable = false)
    private String senha;
}