package com.luisbilecki.openfeignexample.controller;

import com.luisbilecki.openfeignexample.dto.CharacterDTO;
import com.luisbilecki.openfeignexample.dto.CharactersDTO;
import com.luisbilecki.openfeignexample.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharacterController {

    @Autowired
    private CharacterService service;

    @GetMapping("/characters")
    public CharactersDTO getCharacters() {
        return service.getCharacters();
    }

    @GetMapping("/characters/{id}")
    public CharacterDTO getCharacter(@PathVariable Long id) {
        return service.getCharacter(id);
    }

}
