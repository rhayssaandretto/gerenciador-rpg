package com.example.rpg.controllers;

import com.example.rpg.dtos.CharacterDTO;
import com.example.rpg.dtos.UpdateAdventureNameDTO;
import com.example.rpg.entities.Character;
import com.example.rpg.entities.MagicItem;
import com.example.rpg.services.CharacterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/personagens")
public class CharacterController {

    public final CharacterService service;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid CharacterDTO dto) {
        CharacterDTO character = service.create(dto);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(character.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<Character>> findAll() {
        List<Character> characters = service.getAll();

        return ResponseEntity.ok(characters);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Character> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateAdventureNameDTO> updateAdventureName(@PathVariable Long id, @RequestBody @Valid UpdateAdventureNameDTO dto) {
        return ResponseEntity.ok(service.updateAdventureName(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/itens-magicos/{idItem}")
    public ResponseEntity<Void> addMagicItem(@PathVariable Long idCharacter, @PathVariable Long idItem) {
        service.addItemToCharacter(idCharacter, idItem);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/itens-magicos")
    public ResponseEntity<List<MagicItem>> getItemsByCharacterId(@PathVariable Long id) {
        List<MagicItem> items = service.getItemsByCharacterId(id);
        return ResponseEntity.ok(items);
    }

    @DeleteMapping("/{id}/itens-magicos/{itemId}")
    public ResponseEntity<Void> removeItemFromCharacter(@PathVariable Long id, @PathVariable Long itemId) {
        service.removeItemFromCharacter(id, itemId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/amuleto")
    public ResponseEntity<MagicItem> getAmuletByCharacterId(@PathVariable Long id) {
        MagicItem amulet = service.getAmuletByCharacterId(id);
        return ResponseEntity.ok(amulet);
    }
}
