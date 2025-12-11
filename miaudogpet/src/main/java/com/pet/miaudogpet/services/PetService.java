package com.pet.miaudogpet.services;
import com.miaudopt.api.dto.PetRequestDTO;
import com.miaudopt.api.dto.PetResponseDTO;
import com.miaudopt.api.mapper.PetMapper;
import com.miaudopt.api.model.Pet;
import com.miaudopt.api.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PetService {

  private final PetRepository petRepository;

  public List<PetResponseDTO> listar() {
    return petRepository.findAll()
        .stream()
        .map(PetMapper::toResponse)
        .collect(Collectors.toList());
  }

  public PetResponseDTO buscarPorId(Integer id) {
    return petRepository.findById(id)
        .map(PetMapper::toResponse)
        .orElse(null);
  }

  public PetResponseDTO criar(PetRequestDTO dto) {
    Pet entity = PetMapper.toEntity(dto);
    return PetMapper.toResponse(petRepository.save(entity));
  }

  public PetResponseDTO atualizar(Integer id, PetRequestDTO dto) {
    return petRepository.findById(id).map(p -> {
      p.setNome(dto.getNome());
      p.setRaca(dto.getRaca());
      p.setIdade(dto.getIdade());
      p.setPorte(dto.getPorte());
      p.setSexo(dto.getSexo());
      p.setDisponibilidade(dto.getDisponibilidade());
      p.setFotos(dto.getFotos());
      p.setCor(dto.getCor());
      p.setVacinado(dto.getVacinado());
      p.setQtdDoses(dto.getQtd_doses());
      p.setDtRegistro(dto.getDt_registro());
      p.setCastrado(dto.getCastrado());
      p.setDescricao(dto.getDescricao());
      p.setFkEspecie(dto.getFk_especie());
      return PetMapper.toResponse(petRepository.save(p));
    }).orElse(null);
  }

  public void deletar(Integer id) {
    petRepository.deleteById(id);
  }
}
