package com.pet.miaudogpet.controllers;

import com.miaudopt.api.dto.EspecieRequestDTO;
import com.miaudopt.api.dto.EspecieResponseDTO;
import com.miaudopt.api.service.EspecieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/especies")
@RequiredArgsConstructor
public class EspecieController {

  private final EspecieService service;

  @GetMapping
  public ResponseEntity<List<EspecieResponseDTO>> listar() {
    return ResponseEntity.ok(service.listar());
  }

  @GetMapping("/{id}")
  public ResponseEntity<EspecieResponseDTO> buscar(@PathVariable Integer id) {
    EspecieResponseDTO dto = service.buscarPorId(id);
    return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<EspecieResponseDTO> criar(@RequestBody EspecieRequestDTO dto) {
    return ResponseEntity.ok(service.criar(dto));
  }

  @PutMapping("/{id}")
  public ResponseEntity<EspecieResponseDTO> atualizar(
      @PathVariable Integer id,
      @RequestBody EspecieRequestDTO dto) {
    EspecieResponseDTO resp = service.atualizar(id, dto);
    return resp != null ? ResponseEntity.ok(resp) : ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletar(@PathVariable Integer id) {
    service.deletar(id);
    return ResponseEntity.noContent().build();
  }
}
