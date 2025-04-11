package com.example.rpg.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String adventurerName;

    @Column(nullable = false)
    private Integer level;

    @Column(nullable = false)
    private Integer strength;

    @Column(nullable = false)
    private Integer defense;
}
