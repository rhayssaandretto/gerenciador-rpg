package com.example.rpg.validators;

import com.example.rpg.entities.MagicItem;
import com.example.rpg.enums.TipoItem;
import com.example.rpg.exception.InvalidStatsException;

public class MagicItemValidator {

    public static void validateBaseStats(MagicItem item) {
        if (item.getDefesa() == 0 && item.getForca() == 0) {
            throw new InvalidStatsException("O item não pode ter força e defesa zeradas.");
        }
    }

    public static void validate(MagicItem item) {
        if (item.getTipoItem() == TipoItem.ARMA && item.getDefesa() != 0) {
            throw new InvalidStatsException("Armas devem ter defesa igual a zero.");
        }

        if (item.getTipoItem() == TipoItem.ARMADURA && item.getForca() != 0) {
            throw new InvalidStatsException("Armaduras devem ter força igual a zero.");
        }
    }
}
