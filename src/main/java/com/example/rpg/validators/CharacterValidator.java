package com.example.rpg.validators;

import com.example.rpg.entities.Character;
import com.example.rpg.entities.MagicItem;
import com.example.rpg.enums.TipoItem;

public class CharacterValidator {

    //só será chamado na criação do personagem
    public static void validateBaseStats(Character character) throws Exception{
        if(character.getForca() + character.getDefesa() > 10){
            throw new Exception("A quantidade de pontos de defesa e força excedem dez!");
        }
    }

    public static void validateAmuletUniqueness(Character character, MagicItem item) throws Exception {
        if (item.getTipoItem() == TipoItem.AMULETO) {
            long countAmulet = character.getItensMagicos().stream().filter(i -> i.getTipoItem().equals(TipoItem.AMULETO)).count();

            if (countAmulet == 1) {
                throw new Exception("Já existe um item do tipo 'Amuleto'!");
            }
        }
    }
}
