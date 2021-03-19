package com.luisbilecki.openfeignexample.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CharactersDTO {

    private MetadataDTO info;
    private List<CharacterDTO> results;

}
