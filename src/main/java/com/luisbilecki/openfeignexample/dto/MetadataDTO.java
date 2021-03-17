package com.luisbilecki.openfeignexample.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
public class MetadataDTO {

    private Integer count;
    private Integer pages;
    private String next;
    private String prev;

}
