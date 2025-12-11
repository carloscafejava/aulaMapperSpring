package com.pet.miaudogpet.dto;

package com.miauadopt.dto;

import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoadorDTO {
    private Integer id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private LocalDate dtRegistro;
    private LocalDate dtUpdate;
    private LocalDate dtNascimento;
    private Integer loginId;
}