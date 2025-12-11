package com.miauadopt.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

import com.pet.miaudogpet.model.enums.Disponibilidade;
import com.pet.miaudogpet.model.enums.Porte;
import com.pet.miaudogpet.model.enums.Sexo;

@Entity
@Table(name = "pets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private String raca;
    
    @Column(nullable = false)
    private Integer idade;
    
    @Enumerated(EnumType.STRING)
    private Porte porte;
    
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    
    @Enumerated(EnumType.STRING)
    private Disponibilidade disponibilidade;
    
    @Column(nullable = false)
    private String fotos;
    
    @Column(nullable = false)
    private String cor;
    
    @Column(nullable = false)
    private Boolean vacinado;
    
    @Column(name = "qtd_doses")
    private Integer qtdDoses;
    
    @Column(name = "dt_registro")
    private LocalDate dtRegistro;
    
    @Column(nullable = false)
    private Boolean castrado;
    
    @Column(columnDefinition = "TEXT")
    private String descricao;
    
    @ManyToOne
    @JoinColumn(name = "fk_especie", nullable = false)
    private Especie especie;
    
  
}