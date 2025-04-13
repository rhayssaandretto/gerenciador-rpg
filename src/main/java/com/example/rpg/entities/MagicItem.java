package com.example.rpg.entities;

import com.example.rpg.enums.TipoItem;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MagicItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoItem tipoItem;

    private Integer forca;

    private Integer defesa;

    @ManyToOne
    @JoinColumn(name = "character_id")
    @JsonIgnoreProperties("itensMagicos")
    private Character personagem;
}
