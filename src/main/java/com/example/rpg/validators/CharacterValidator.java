package com.example.rpg.validators;

import com.example.rpg.entities.Character;
import com.example.rpg.entities.MagicItem;
import com.example.rpg.enums.TipoItem;
import com.example.rpg.exception.InvalidStatsException;

public class CharacterValidator {

    public static void validateBaseStats(Character character) {
        if (character.getForca() + character.getDefesa() > 10) {
            throw new InvalidStatsException("A soma de força e defesa não pode exceder 10 pontos.");
        }
    }

    public static void validateAmuletUniqueness(Character character, MagicItem item) {
        if (item.getTipoItem() == TipoItem.AMULETO) {
            long countAmulet = character.getItensMagicos()
                    .stream()
                    .filter(i -> i.getTipoItem()
                            .equals(TipoItem.AMULETO)).count();

            if (countAmulet == 1) {
                throw new InvalidStatsException("Já existe um item do tipo 'Amuleto'!");
            }
        }
    }
}
