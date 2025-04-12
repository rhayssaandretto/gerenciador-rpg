package com.example.rpg.entities;


import com.example.rpg.enums.Classe;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_character")
    private List<MagicItem> itensMagicos = new ArrayList<>();

    @Max(10)
    private Integer forca;

    @Max(10)
    private Integer defesa;
}
