package com.luisbilecki.openfeignexample.controller;

import com.luisbilecki.openfeignexample.dto.CharacterDTO;
import com.luisbilecki.openfeignexample.dto.CharactersDTO;
import com.luisbilecki.openfeignexample.service.CharacterService;
import feign.FeignException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CharacterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CharacterService characterService;

    private String CHARACTERS_BASE_URL = "/characters";

    @Test
    public void getCharactersShouldReturnCharacterList() throws Exception {
        CharactersDTO charactersDTO = CharactersDTO.builder().info(null).results(null).build();
        when(characterService.getCharacters()).thenReturn(charactersDTO);

        mockMvc.perform(MockMvcRequestBuilders.get(CHARACTERS_BASE_URL))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void getCharactersShouldReturnIntegrationError() throws Exception {
        when(characterService.getCharacters()).thenThrow(FeignException.class);

        mockMvc.perform(MockMvcRequestBuilders.get(CHARACTERS_BASE_URL))
                .andExpect(status().is5xxServerError())
                .andReturn();
    }

    @Test
    public void getCharacterShouldReturnCharacter() throws Exception {
        CharacterDTO characterDTO = CharacterDTO.builder().build();
        when(characterService.getCharacter(any())).thenReturn(characterDTO);

        mockMvc.perform(MockMvcRequestBuilders.get(CHARACTERS_BASE_URL))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void getCharacterShouldReturnIntegrationError() throws Exception {
        when(characterService.getCharacter(any())).thenThrow(FeignException.class);

        mockMvc.perform(MockMvcRequestBuilders.get(CHARACTERS_BASE_URL + "/1"))
                .andExpect(status().is5xxServerError())
                .andReturn();
    }
}