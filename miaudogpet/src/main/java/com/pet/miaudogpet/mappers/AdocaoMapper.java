package com.pet.miaudogpet.mappers;

// ===== ADOCAO MAPPER =====
/**
 * Mapper para Adocao
 * Possui múltiplos relacionamentos (Adotante, Doador, Pet)
 * Mapeia também para DTOs relacionadas
 */
package com.miauadopt.mapper;

import com.miauadopt.dto.AdocaoDTO;
import com.miauadopt.model.Adocao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {
    AdotanteMapper.class, 
    DoadorMapper.class, 
    PetMapper.class
})
public interface AdocaoMapper {
    
    // Entity -> DTO completo com relacionamentos
    @Mapping(source = "adotante.id", target = "adotanteId")
    @Mapping(source = "doador.id", target = "doadorId")
    @Mapping(source = "pet.id", target = "petId")
    @Mapping(source = "statusAdocao", target = "statusAdocao")
    AdocaoDTO toDTO(Adocao adocao);
    
    // DTO -> Entity
    @Mapping(target = "adotante", ignore = true)
    @Mapping(target = "doador", ignore = true)
    @Mapping(target = "pet", ignore = true)
    @Mapping(source = "statusAdocao", target = "statusAdocao")
    Adocao toEntity(AdocaoDTO adocaoDTO);
}
