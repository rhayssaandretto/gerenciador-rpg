package com.example.rpg.services;

import com.example.rpg.dtos.CharacterDTO;
import com.example.rpg.dtos.UpdateAdventureNameDTO;
import com.example.rpg.entities.Character;
import com.example.rpg.entities.MagicItem;
import com.example.rpg.enums.TipoItem;
import com.example.rpg.exception.InvalidStatsException;
import com.example.rpg.repositories.CharacterRepository;
import com.example.rpg.validators.CharacterValidator;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CharacterService {

    private final CharacterRepository repository;
    private final MagicItemService magicItemService;
    private final ModelMapper modelMapper;


    public CharacterDTO create(CharacterDTO dto) {
        Character character = modelMapper.map(dto, Character.class);

        try {
            CharacterValidator.validateBaseStats(character);
        } catch (Exception e) {
            throw new InvalidStatsException(e.getMessage());
        }

        Character newCharacter = repository.save(character);
        return modelMapper.map(newCharacter, CharacterDTO.class);
    }

    public List<Character> getAll() {
        return repository.findAll();
    }

    public Character findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Personagem não encontrado!"));
    }


    public UpdateAdventureNameDTO updateAdventureName(Long id, UpdateAdventureNameDTO dto) {
        Character character = this.findById(id);

        character.setNomeAventureiro(dto.getNomeAventureiro());

        Character updatedCharacter = repository.save(character);

        return modelMapper.map(updatedCharacter, UpdateAdventureNameDTO.class);

    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void addItemToCharacter(Long idCharacter, Long idItem) {
        Character character = this.findById(idCharacter);
        MagicItem item = magicItemService.findById(idItem);


        try {
            CharacterValidator.validateAmuletUniqueness(character, item);
        } catch (Exception e) {
            throw new InvalidStatsException(e.getMessage());
        }

        character.getItensMagicos().add(item);

        this.updateStrengthAndDefensePoints(character, item);
    }

    public List<MagicItem> getItemsByCharacterId(Long id) {
        Character character = this.findById(id);
        return character.getItensMagicos();
    }

    public void removeItemFromCharacter(Long idCharacter, Long idItem) {
        Character character = this.findById(idCharacter);
        MagicItem item = magicItemService.findById(idItem);

        character.getItensMagicos().remove(item);
        this.removeStrengthAndDefensePoints(character, item);

        repository.save(character);
    }

    public MagicItem getAmuletByCharacterId(Long id) {
        Character character = this.findById(id);

        for (MagicItem item : character.getItensMagicos()) {
            if (item.getTipoItem().equals(TipoItem.AMULETO)) {
                return item;
            }

        }
        throw new RuntimeException("Amuleto não encontrado!");
    }

    public void updateStrengthAndDefensePoints(Character character, MagicItem item) {

        character.setForca(character.getForca() + item.getForca());
        character.setDefesa(character.getDefesa() + item.getDefesa());

        repository.save(character);
    }

    public void removeStrengthAndDefensePoints(Character character, MagicItem item) {

        character.setForca(character.getForca() - item.getForca());
        character.setDefesa(character.getDefesa() - item.getDefesa());

        repository.save(character);
    }

}
