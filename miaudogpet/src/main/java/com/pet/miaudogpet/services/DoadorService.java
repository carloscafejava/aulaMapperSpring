package com.pet.miaudogpet.services;
import com.miaudopt.api.dto.DoadorRequestDTO;
import com.miaudopt.api.dto.DoadorResponseDTO;
import com.miaudopt.api.mapper.DoadorMapper;
import com.miaudopt.api.model.Doador;
import com.miaudopt.api.repository.DoadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoadorService {

  private final DoadorRepository doadorRepository;

  public List<DoadorResponseDTO> listar() {
    return doadorRepository.findAll()
        .stream()
        .map(DoadorMapper::toResponse)
        .collect(Collectors.toList());
  }

  public DoadorResponseDTO buscarPorId(Integer id) {
    return doadorRepository.findById(id)
        .map(DoadorMapper::toResponse)
        .orElse(null);
  }

  public DoadorResponseDTO criar(DoadorRequestDTO dto) {
    Doador entity = DoadorMapper.toEntity(dto);
    return DoadorMapper.toResponse(doadorRepository.save(entity));
  }

  public DoadorResponseDTO atualizar(Integer id, DoadorRequestDTO dto) {
    return doadorRepository.findById(id).map(d -> {
      d.setNome(dto.getNome());
      d.setCpf(dto.getCpf());
      d.setTelefone(dto.getTelefone());
      d.setEmail(dto.getEmail());
      d.setDtRegistro(dto.getDt_registro());
      d.setDtUpdate(dto.getDt_update());
      d.setDtNascimento(dto.getDt_nascimento());
      d.setFkLogin(dto.getFk_login());
      return DoadorMapper.toResponse(doadorRepository.save(d));
    }).orElse(null);
  }

  public void deletar(Integer id) {
    doadorRepository.deleteById(id);
  }
}
