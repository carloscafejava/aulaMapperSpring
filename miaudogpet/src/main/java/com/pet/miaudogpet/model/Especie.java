
// ===== ESPECIE.JAVA =====
package com.miauadopt.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "especies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Especie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "nome_especie", nullable = false)
    private String nomeEspecie;
}