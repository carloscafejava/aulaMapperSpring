package com.miauadopt.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "doadores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false)
    private String nome;
    
    @Column(length = 15, unique = true)
    private String cpf;
    
    @Column(length = 15)
    private String telefone;
    
    @Column(nullable = false)
    private String email;
    
    @Column(name = "dt_registro")
    private LocalDate dtRegistro;
    
    @Column(name = "dt_update")
    private LocalDate dtUpdate;
    
    @Column(name = "dt_nascimento")
    private LocalDate dtNascimento;
    
    @ManyToOne
    @JoinColumn(name = "fk_login")
    private Login login;
}