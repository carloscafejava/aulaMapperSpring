package com.pet.miaudogpet.services;


import com.miaudopt.api.dto.LoginRequestDTO;
import com.miaudopt.api.dto.LoginResponseDTO;
import com.miaudopt.api.mapper.LoginMapper;
import com.miaudopt.api.model.Login;
import com.miaudopt.api.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoginService {

  private final LoginRepository loginRepository;

  public List<LoginResponseDTO> listar() {
    return loginRepository.findAll()
        .stream()
        .map(LoginMapper::toResponse)
        .collect(Collectors.toList());
  }

  public LoginResponseDTO buscarPorId(Integer id) {
    return loginRepository.findById(id)
        .map(LoginMapper::toResponse)
        .orElse(null);
  }

  public LoginResponseDTO criar(LoginRequestDTO dto) {
    Login entity = LoginMapper.toEntity(dto);
    Login salvo = loginRepository.save(entity);
    return LoginMapper.toResponse(salvo);
  }

  public LoginResponseDTO atualizar(Integer id, LoginRequestDTO dto) {
    return loginRepository.findById(id).map(login -> {
      login.setUsuario(dto.getUsuario());
      login.setEmail(dto.getEmail());
      login.setTelefone(dto.getTelefone());
      login.setSenha(dto.getSenha());
      return LoginMapper.toResponse(loginRepository.save(login));
    }).orElse(null);
  }

  public void deletar(Integer id) {
    loginRepository.deleteById(id);
  }
}
