package com.example.rpg.controllers;

import com.example.rpg.dtos.MagicItemDTO;
import com.example.rpg.entities.MagicItem;
import com.example.rpg.services.MagicItemService;
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
@RequestMapping("/itens-magicos")
public class MagicItemController {

    public final MagicItemService service;
    private final ModelMapper modelMapper;


    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid MagicItemDTO dto) {
        MagicItemDTO item = service.create(dto);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(item.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    // Listar todos os itens mágicos
    @GetMapping
    public ResponseEntity<List<MagicItem>> findAll() {
        List<MagicItem> items = service.findAll();
        return ResponseEntity.ok(items);
    }

    // Buscar um item mágico pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<MagicItem> findById(@PathVariable Long id) {
        MagicItem item = service.findById(id);
        return ResponseEntity.ok(item);
    }
}
