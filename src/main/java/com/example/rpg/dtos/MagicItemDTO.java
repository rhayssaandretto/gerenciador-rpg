package com.example.rpg.dtos;

import com.example.rpg.enums.TipoItem;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MagicItemDTO {

    private  Long id;


    @NotNull(message = "Campo 'nome' não pode ser nulo!")
    private String nome;

    @NotNull(message = "Campo 'tipoItem' é obrigatório!")
    private TipoItem tipoItem;

    @NotNull(message = "Campo 'força' é obrigatório!")
    @Min(value = 0, message = "Valor mínimo de força é 0")
    @Max(value = 10, message = "Valor máximo de força é 10")
    private Integer forca;

    @NotNull(message = "Campo 'defesa' é obrigatório!")
    @Min(value = 0, message = "Valor mínimo de defesa é 0")
    @Max(value = 10, message = "Valor máximo de defesa é 10")
    private Integer defesa;
}
