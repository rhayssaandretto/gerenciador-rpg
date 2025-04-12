package com.example.rpg.controllers;

import com.example.rpg.services.CharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/personagens")
public class CharacterController {

    private final CharacterService service;
}
