package com.example.rpg.entities;


import com.example.rpg.enums.Classe;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String nomeAventureiro;

    @Enumerated(EnumType.STRING)
    private Classe classe;

    private Integer level;

    @OneToMany(mappedBy = "character", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MagicItem> itensMagicos = new ArrayList<>();

    @Max(10)
    private Integer forca;

    @Max(10)
    private Integer defesa;
}
