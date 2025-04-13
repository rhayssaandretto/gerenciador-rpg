package com.example.rpg.services;

import com.example.rpg.dtos.MagicItemDTO;
import com.example.rpg.entities.MagicItem;
import com.example.rpg.exception.InvalidStatsException;
import com.example.rpg.repositories.MagicItemRepository;
import com.example.rpg.validators.CharacterValidator;
import com.example.rpg.validators.MagicItemValidator;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MagicItemService {

    private final MagicItemRepository repository;
    private final ModelMapper modelMapper;

    public MagicItemDTO create(MagicItemDTO dto){
        MagicItem item = modelMapper.map(dto, MagicItem.class);

        try {
            MagicItemValidator.validateBaseStats(item);
            MagicItemValidator.validate(item);
        } catch (Exception e) {
            throw new InvalidStatsException(e.getMessage());
        }

        MagicItem newItem = repository.save(item);
        return modelMapper.map(newItem, MagicItemDTO.class);
    }

    public List<MagicItem> findAll() {
        return repository.findAll();
    }

    public MagicItem findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item mágico não encontrado!"));
    }
}
