package com.example.rpg.controllers;

import com.example.rpg.repositories.MagicItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MagicItemService {

    private final MagicItemRepository repository;
}
