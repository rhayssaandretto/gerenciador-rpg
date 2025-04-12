package com.example.rpg.controllers;

import com.example.rpg.services.MagicItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/itensMagicos")
public class MagicItemController {

    private final MagicItemService service;
}
