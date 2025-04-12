package com.example.rpg.validators;

import com.example.rpg.entities.MagicItem;
import com.example.rpg.enums.TipoItem;

public class MagicItemValidator {

    public static void validateBaseStats(MagicItem item) throws Exception {
        if (item.getDefesa() == 0 && item.getForca() == 0) {
            throw new Exception("O item não pode ter defesa e força zerados!");
        }
    }

    public static void validate(MagicItem item) throws Exception {
        if (item.getTipoItem() == TipoItem.ARMA && item.getDefesa() != 0) {
            throw new Exception("A defesa do item tipo 'Arma' deve ser obrigatoriamente zero!");
        }

        if (item.getTipoItem() == TipoItem.ARMADURA && item.getForca() != 0) {
            throw new Exception("A força do item tipo 'Armadura' deve ser obrigatoriamente zero!");
        }
    }
}
