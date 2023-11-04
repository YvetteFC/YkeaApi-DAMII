package com.ykeas.ykeasmsprincipal.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PlateEditDto {

    private String name;

    private Double price;

    private Integer stock;

    private String description;

    private String imageUrl;

    private Long categoryId;
}
