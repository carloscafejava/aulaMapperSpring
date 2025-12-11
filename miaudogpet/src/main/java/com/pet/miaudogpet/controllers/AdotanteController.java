package com.pet.miaudogpet.controllers;

import com.miaudopt.api.dto.AdotanteRequestDTO;
import com.miaudopt.api.dto.AdotanteResponseDTO;
import com.miaudopt.api.service.AdotanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adotantes")
@RequiredArgsConstructor
public class AdotanteController {

  private final AdotanteService service;

  @GetMapping
  public ResponseEntity<List<AdotanteResponseDTO>> listar() {
    return ResponseEntity.ok(service.listar());
  }

  @GetMapping("/{id}")
  public ResponseEntity<AdotanteResponseDTO> buscar(@PathVariable Integer id) {
    AdotanteResponseDTO dto = service.buscarPorId(id);
    return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<AdotanteResponseDTO> criar(@RequestBody AdotanteRequestDTO dto) {
    return ResponseEntity.ok(service.criar(dto));
  }

  @PutMapping("/{id}")
  public ResponseEntity<AdotanteResponseDTO> atualizar(
      @PathVariable Integer id,
      @RequestBody AdotanteRequestDTO dto) {
    AdotanteResponseDTO atualizado = service.atualizar(id, dto);
    return atualizado != null ? ResponseEntity.ok(atualizado) : ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletar(@PathVariable Integer id) {
    service.deletar(id);
    return ResponseEntity.noContent().build();
  }
}
