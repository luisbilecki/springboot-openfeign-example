package com.luisbilecki.openfeignexample.service;

import com.luisbilecki.openfeignexample.dto.CharacterDTO;
import com.luisbilecki.openfeignexample.dto.CharactersDTO;

public interface CharacterService {

    public CharactersDTO getCharacters();

    public CharacterDTO getCharacter(Long id);

}
