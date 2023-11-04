package com.ykeas.ykeasmsprincipal.model.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlateCreateRequest {

    @NotBlank(message = "name is required")
    @Size(min = 2, max = 20, message = "error name size")
    private String name;

    @NotNull(message = "price is required")
    @Min(value = 0, message = "the lower price is 0")
    private Double price;

    @NotNull(message = "stock is required")
    private Integer stock;

    @NotBlank(message = "description is required")
    @Size(min = 2, max = 50, message = "error description size")
    private String description;

    @NotNull(message = "imageUrl is required")
    private String imageUrl;

    @NotNull(message = "categoryId is required")
    private Long categoryId;
}
