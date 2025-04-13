package com.example.rpg.entities;


import com.example.rpg.enums.Classe;
import com.example.rpg.validators.OnCreate;
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

    @Max(value = 10, groups = OnCreate.class)
    private Integer forca;

    @Max(value = 10, groups = OnCreate.class)
    private Integer defesa;
}
