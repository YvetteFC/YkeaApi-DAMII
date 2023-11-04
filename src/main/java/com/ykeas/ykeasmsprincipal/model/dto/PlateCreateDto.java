package com.ykeas.ykeasmsprincipal.model.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PlateCreateDto {

    private String name;

    private Double price;

    private Integer stock;

    private String description;

    private String imageUrl;

    private Long categoryId;
}
