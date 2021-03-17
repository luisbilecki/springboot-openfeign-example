package com.luisbilecki.openfeignexample.clients;

import com.luisbilecki.openfeignexample.dto.CharacterDTO;
import com.luisbilecki.openfeignexample.dto.CharactersDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "rickAndMortyClient", url = "${rickAndMorty.url}")
public interface RickAndMortyClient {

    @RequestMapping(method = RequestMethod.GET, value = "/character")
    CharactersDTO getCharacters();

    @RequestMapping(method = RequestMethod.GET, value = "/character/{id}")
    CharacterDTO getCharacter(@PathVariable("id") Long id);

}
