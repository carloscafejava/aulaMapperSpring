package com.pet.miaudogpet.controllers;

import com.miaudopt.api.dto.AdocaoRequestDTO;
import com.miaudopt.api.dto.AdocaoResponseDTO;
import com.miaudopt.api.service.AdocaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adocoes")
@RequiredArgsConstructor
public class AdocaoController {

  private final AdocaoService service;

  @GetMapping
  public ResponseEntity<List<AdocaoResponseDTO>> listar() {
    return ResponseEntity.ok(service.listar());
  }

  @GetMapping("/{id}")
  public ResponseEntity<AdocaoResponseDTO> buscar(@PathVariable Integer id) {
    AdocaoResponseDTO dto = service.buscarPorId(id);
    return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<AdocaoResponseDTO> criar(@RequestBody AdocaoRequestDTO dto) {
    return ResponseEntity.ok(service.criar(dto));
  }

  @PutMapping("/{id}")
  public ResponseEntity<AdocaoResponseDTO> atualizar(
      @PathVariable Integer id,
      @RequestBody AdocaoRequestDTO dto) {
    AdocaoResponseDTO atualizado = service.atualizar(id, dto);
    return atualizado != null ? ResponseEntity.ok(atualizado) : ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletar(@PathVariable Integer id) {
    service.deletar(id);
    return ResponseEntity.noContent().build();
  }
}
