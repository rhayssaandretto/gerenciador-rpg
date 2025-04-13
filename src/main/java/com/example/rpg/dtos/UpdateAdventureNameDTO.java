package com.example.rpg.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAdventureNameDTO {

    @NotBlank(message = "Campo não pode estar vazio!")
    private String nomeAventureiro;
}
