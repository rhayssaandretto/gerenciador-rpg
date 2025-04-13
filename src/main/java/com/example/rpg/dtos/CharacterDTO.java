package com.example.rpg.dtos;

import com.example.rpg.enums.Classe;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterDTO {
    private Long id;

    @NotBlank(message = "Campo não pode estar vazio!")
    private String nome;

    @NotBlank(message = "Campo não pode estar vazio!")
    private String nomeAventureiro;

    @NotNull(message = "Campo não pode estar vazio!")
    private Integer level;

    private Classe classe;

    @NotNull(message = "Campo não pode estar vazio!")
    @Min(value = 0, message = "Força mínima é 0")
    @Max(value = 10, message = "Força máxima é 10")
    private Integer forca;

    @NotNull(message = "Campo não pode estar vazio!")
    @Min(value = 0, message = "Força mínima é 0")
    @Max(value = 10, message = "Força máxima é 10")
    private Integer defesa;

}
