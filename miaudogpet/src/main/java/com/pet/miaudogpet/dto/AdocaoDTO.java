package com.pet.miaudogpet.dto;
package com.miauadopt.dto;

import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdocaoDTO {
    private Integer id;
    private Integer adotanteId;
    private Integer doadorId;
    private Integer petId;
    private LocalDate dtAdocao;
    private String statusAdocao; // DISPONÍVEL, EM_PROCESSO, ADOTADO
    private String motivoAdotante;
    private String motivoDoador;
    private String observacoes;
    
    // Para retorno com detalhes
    private AdotanteDTO adotante;
    private DoadorDTO doador;
    private PetDTO pet;
}