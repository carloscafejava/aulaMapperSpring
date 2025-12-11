package com.pet.miaudogpet.services;


import com.miaudopt.api.dto.EspecieRequestDTO;
import com.miaudopt.api.dto.EspecieResponseDTO;
import com.miaudopt.api.mapper.EspecieMapper;
import com.miaudopt.api.model.Especie;
import com.miaudopt.api.repository.EspecieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EspecieService {

  private final EspecieRepository especieRepository;

  public List<EspecieResponseDTO> listar() {
    return especieRepository.findAll()
        .stream()
        .map(EspecieMapper::toResponse)
        .collect(Collectors.toList());
  }

  public EspecieResponseDTO buscarPorId(Integer id) {
    return especieRepository.findById(id)
        .map(EspecieMapper::toResponse)
        .orElse(null);
  }

  public EspecieResponseDTO criar(EspecieRequestDTO dto) {
    Especie entity = EspecieMapper.toEntity(dto);
    Especie salvo = especieRepository.save(entity);
    return EspecieMapper.toResponse(salvo);
  }

  public EspecieResponseDTO atualizar(Integer id, EspecieRequestDTO dto) {
    return especieRepository.findById(id).map(especie -> {
      especie.setNomeEspecie(dto.getNomeEspecie());
      return EspecieMapper.toResponse(especieRepository.save(especie));
    }).orElse(null);
  }

  public void deletar(Integer id) {
    especieRepository.deleteById(id);
  }
}
