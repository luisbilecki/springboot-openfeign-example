package com.luisbilecki.openfeignexample.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CharacterDTO {

    private Integer id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private OriginDTO origin;
    private LocationDTO location;
    private String image;
    private List<String> episode;
    private String url;
    private String created;

}
