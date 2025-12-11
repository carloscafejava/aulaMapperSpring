package com.pet.miaudogpet.controllers;


import com.miaudopt.api.dto.LoginRequestDTO;
import com.miaudopt.api.dto.LoginResponseDTO;
import com.miaudopt.api.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

  private final LoginService service;

  @GetMapping
  public ResponseEntity<List<LoginResponseDTO>> listar() {
    return ResponseEntity.ok(service.listar());
  }

  @GetMapping("/{id}")
  public ResponseEntity<LoginResponseDTO> buscar(@PathVariable Integer id) {
    LoginResponseDTO dto = service.buscarPorId(id);
    return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<LoginResponseDTO> criar(@RequestBody LoginRequestDTO dto) {
    return ResponseEntity.ok(service.criar(dto));
  }

  @PutMapping("/{id}")
  public ResponseEntity<LoginResponseDTO> atualizar(
      @PathVariable Integer id,
      @RequestBody LoginRequestDTO dto) {
    LoginResponseDTO atualizado = service.atualizar(id, dto);
    return atualizado != null ? ResponseEntity.ok(atualizado) : ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletar(@PathVariable Integer id) {
    service.deletar(id);
    return ResponseEntity.noContent().build();
  }
}
