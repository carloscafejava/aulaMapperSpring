package com.miauadopt.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "adocoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Adocao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "fk_adotante")
    private Adotante adotante;
    
    @ManyToOne
    @JoinColumn(name = "fk_doador")
    private Doador doador;
    
    @ManyToOne
    @JoinColumn(name = "fk_pet", nullable = false)
    private Pet pet;
    
    @Column(name = "dt_adocao")
    private LocalDate dtAdocao;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status_adocao")
    private StatusAdocao statusAdocao;
    
    @Column(name = "motivo_adotante", columnDefinition = "TEXT")
    private String motivoAdotante;
    
    @Column(name = "motivo_doador", columnDefinition = "TEXT")
    private String motivoDoador;
    
    @Column(columnDefinition = "TEXT")
    private String observacoes;
    
    public enum StatusAdocao {
        DISPONÍVEL, EM_PROCESSO, ADOTADO
    }
}