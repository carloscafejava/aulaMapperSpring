package com.pet.miaudogpet.controllers;

@RestController
@RequestMapping("/pets")
@RequiredArgsConstructor
public class PetController {

  private final PetService service;

  @GetMapping
  public ResponseEntity<List<PetResponseDTO>> listar() {
    return ResponseEntity.ok(service.listar());
  }

  @GetMapping("/{id}")
  public ResponseEntity<PetResponseDTO> buscar(@PathVariable Integer id) {
    PetResponseDTO dto = service.buscarPorId(id);
    return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<PetResponseDTO> criar(@RequestBody PetRequestDTO dto) {
    return ResponseEntity.ok(service.criar(dto));
  }

  @PutMapping("/{id}")
  public ResponseEntity<PetResponseDTO> atualizar(
      @PathVariable Integer id,
      @RequestBody PetRequestDTO dto) {
    PetResponseDTO atualizado = service.atualizar(id, dto);
    return atualizado != null ? ResponseEntity.ok(atualizado) : ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletar(@PathVariable Integer id) {
    service.deletar(id);
    return ResponseEntity.noContent().build();
  }
}
