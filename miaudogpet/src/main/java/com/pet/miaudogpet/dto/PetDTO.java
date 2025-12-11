package com.pet.miaudogpet.dto;


import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetDTO {
    private Integer id;
    private String nome;
    private String raca;
    private Integer idade;
    private String porte; // pequeno, médio, grande
    private String sexo;  // F, M
    private String disponibilidade; // Disponível, Adotado
    private String fotos;
    private String cor;
    private Boolean vacinado;
    private Integer qtdDoses;
    private LocalDate dtRegistro;
    private Boolean castrado;
    private String descricao;
    private Integer especieId;
    private String nomeEspecie; // Para retorno
}
