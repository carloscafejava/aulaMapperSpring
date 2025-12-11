package com.pet.miaudogpet.controllers;

import com.miaudopt.api.dto.DoadorRequestDTO;
import com.miaudopt.api.dto.DoadorResponseDTO;
import com.miaudopt.api.service.DoadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doadores")
@RequiredArgsConstructor
public class DoadorController {

  private final DoadorService service;

  @GetMapping
  public ResponseEntity<List<DoadorResponseDTO>> listar() {
    return ResponseEntity.ok(service.listar());
  }

  @GetMapping("/{id}")
  public ResponseEntity<DoadorResponseDTO> buscar(@PathVariable Integer id) {
    DoadorResponseDTO dto = service.buscarPorId(id);
    return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<DoadorResponseDTO> criar(@RequestBody DoadorRequestDTO dto) {
    return ResponseEntity.ok(service.criar(dto));
  }

  @PutMapping("/{id}")
  public ResponseEntity<DoadorResponseDTO> atualizar(
      @PathVariable Integer id,
      @RequestBody DoadorRequestDTO dto) {
    DoadorResponseDTO atualizado = service.atualizar(id, dto);
    return atualizado != null ? ResponseEntity.ok(atualizado) : ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletar(@PathVariable Integer id) {
    service.deletar(id);
    return ResponseEntity.noContent().build();
  }
}
