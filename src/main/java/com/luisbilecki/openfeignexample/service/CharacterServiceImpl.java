package com.luisbilecki.openfeignexample.service;

import com.luisbilecki.openfeignexample.clients.RickAndMortyClient;
import com.luisbilecki.openfeignexample.dto.CharacterDTO;
import com.luisbilecki.openfeignexample.dto.CharactersDTO;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private RickAndMortyClient client;

    @Override
    public CharactersDTO getCharacters() {
        try {
            log.info("CharacterServiceImpl.getCharacters - start");
            CharactersDTO response = client.getCharacters();
            log.info("CharacterServiceImpl.getCharacters - end");

            return response;
        } catch (FeignException ex) {
            log.error("CharacterServiceImpl.getCharacters - error - {}", ex.getMessage(), ex);
            return new CharactersDTO();
        }
    }

    @Override
    public CharacterDTO getCharacter(Long id) {
        try {
            log.info("CharacterServiceImpl.getCharacter - start - id: {}", id);
            CharacterDTO response = client.getCharacter(id);
            log.info("CharacterServiceImpl.getCharacter - end");

            return response;
        } catch (FeignException ex) {
            log.error("CharacterServiceImpl.getCharacter - error - id: {}, message: {}", id, ex.getMessage(), ex);
            return new CharacterDTO();
        }
    }

}
