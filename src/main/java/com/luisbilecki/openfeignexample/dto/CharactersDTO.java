package com.luisbilecki.openfeignexample.dto;

import lombok.Data;

import java.util.List;

@Data
public class CharactersDTO {

    private MetadataDTO info;
    private List<CharacterDTO> results;

}
