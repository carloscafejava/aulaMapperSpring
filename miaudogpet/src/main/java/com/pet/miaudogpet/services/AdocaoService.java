package com.pet.miaudogpet.services;

import com.miaudopt.api.dto.AdocaoRequestDTO;
import com.miaudopt.api.dto.AdocaoResponseDTO;
import com.miaudopt.api.mapper.AdocaoMapper;
import com.miaudopt.api.model.Adocao;
import com.miaudopt.api.repository.AdocaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdocaoService {

  private final AdocaoRepository adocaoRepository;

  public List<AdocaoResponseDTO> listar() {
    return adocaoRepository.findAll()
        .stream()
        .map(AdocaoMapper::toResponse)
        .collect(Collectors.toList());
  }

  public AdocaoResponseDTO buscarPorId(Integer id) {
    return adocaoRepository.findById(id)
        .map(AdocaoMapper::toResponse)
        .orElse(null);
  }

  public AdocaoResponseDTO criar(AdocaoRequestDTO dto) {
    Adocao entity = AdocaoMapper.toEntity(dto);
    return AdocaoMapper.toResponse(adocaoRepository.save(entity));
  }

  public AdocaoResponseDTO atualizar(Integer id, AdocaoRequestDTO dto) {
    return adocaoRepository.findById(id).map(a -> {
      a.setFkAdotante(dto.getFk_adotante());
      a.setFkDoador(dto.getFk_doador());
      a.setFkPet(dto.getFk_pet());
      a.setDtAdocao(dto.getDt_adocao());
      a.setStatusAdocao(dto.getStatus_adocao());
      a.setMotivoAdotante(dto.getMotivo_adotante());
      a.setMotivoDoador(dto.getMotivo_doador());
      a.setObservacoes(dto.getObservacoes());
      return AdocaoMapper.toResponse(adocaoRepository.save(a));
    }).orElse(null);
  }

  public void deletar(Integer id) {
    adocaoRepository.deleteById(id);
  }
}
