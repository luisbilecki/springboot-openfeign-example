package com.luisbilecki.openfeignexample.dto;

import lombok.Data;

@Data
public class MetadataDTO {

    private Integer count;
    private Integer pages;
    private String next;
    private String prev;

}
