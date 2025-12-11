package com.pet.miaudogpet.mappers;

// ===== ADOTANTE MAPPER =====
/**
 * Mapper simples para Adotante
 * Sem relacionamentos complexos
 */
package com.miauadopt.mapper;

import com.miauadopt.dto.AdotanteDTO;
import com.miauadopt.model.Adotante;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdotanteMapper {
    
    AdotanteDTO toDTO(Adotante adotante);
    
    Adotante toEntity(AdotanteDTO adotanteDTO);
}

// ===== DOADOR MAPPER =====
/**
 * Mapper para Doador
 * Possui relacionamento com Login
 */
package com.miauadopt.mapper;

import com.miauadopt.dto.DoadorDTO;
import com.miauadopt.model.Doador;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DoadorMapper {
    
    // Entity -> DTO
    @Mapping(source = "login.id", target = "loginId")
    DoadorDTO toDTO(Doador doador);
    
    // DTO -> Entity
    @Mapping(target = "login", ignore = true)
    Doador toEntity(DoadorDTO doadorDTO);
}