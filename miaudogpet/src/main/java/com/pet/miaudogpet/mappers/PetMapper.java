package com.pet.miaudogpet.mappers;

// ===== PET MAPPER =====
/**
 * Mapper para Pet
 * Mais complexo pois Pet tem relacionamento com Especie
 */
package com.miauadopt.mapper;

import com.miauadopt.dto.PetDTO;
import com.miauadopt.model.Pet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PetMapper {
    
    // Entity -> DTO
    // @Mapping mapeia campos com nomes diferentes
    // source: campo da entity, target: campo do DTO
    @Mapping(source = "especie.id", target = "especieId")
    @Mapping(source = "especie.nomeEspecie", target = "nomeEspecie")
    @Mapping(source = "porte", target = "porte")
    @Mapping(source = "sexo", target = "sexo")
    @Mapping(source = "disponibilidade", target = "disponibilidade")
    PetDTO toDTO(Pet pet);
    
    // DTO -> Entity
    @Mapping(target = "especie", ignore = true)
    @Mapping(source = "porte", target = "porte")
    @Mapping(source = "sexo", target = "sexo")
    @Mapping(source = "disponibilidade", target = "disponibilidade")
    Pet toEntity(PetDTO petDTO);
}
