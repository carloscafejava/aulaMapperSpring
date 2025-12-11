package com.pet.miaudogpet.mappers;

// ===== ESPECIE MAPPER =====
/**
 * Mapper para Especie
 * Converte entre Entity (banco) e DTO (API)
 */
package com.miauadopt.mapper;

import com.miauadopt.dto.EspecieDTO;
import com.miauadopt.model.Especie;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EspecieMapper {
    
    // Entity -> DTO (retorno para cliente)
    EspecieDTO toDTO(Especie especie);
    
    // DTO -> Entity (recebido do cliente)
    Especie toEntity(EspecieDTO especieDTO);
}