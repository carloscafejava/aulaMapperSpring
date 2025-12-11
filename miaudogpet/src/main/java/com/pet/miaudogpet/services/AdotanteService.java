package com.pet.miaudogpet.services;

import com.miaudopt.api.dto.AdotanteRequestDTO;
import com.miaudopt.api.dto.AdotanteResponseDTO;
import com.miaudopt.api.mapper.AdotanteMapper;
import com.miaudopt.api.model.Adotante;
import com.miaudopt.api.repository.AdotanteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdotanteService {

  private final AdotanteRepository adotanteRepository;

  public List<AdotanteResponseDTO> listar() {
    return adotanteRepository.findAll()
        .stream()
        .map(AdotanteMapper::toResponse)
        .collect(Collectors.toList());
  }

  public AdotanteResponseDTO buscarPorId(Integer id) {
    return adotanteRepository.findById(id)
        .map(AdotanteMapper::toResponse)
        .orElse(null);
  }

  public AdotanteResponseDTO criar(AdotanteRequestDTO dto) {
    Adotante entity = AdotanteMapper.toEntity(dto);
    return AdotanteMapper.toResponse(adotanteRepository.save(entity));
  }

  public AdotanteResponseDTO atualizar(Integer id, AdotanteRequestDTO dto) {
    return adotanteRepository.findById(id).map(a -> {
      a.setNome(dto.getNome());
      a.setTelefone(dto.getTelefone());
      a.setEmail(dto.getEmail());
      return AdotanteMapper.toResponse(adotanteRepository.save(a));
    }).orElse(null);
  }

  public void deletar(Integer id) {
    adotanteRepository.deleteById(id);
  }
}
