package com.ykeas.ykeasmsprincipal.model.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    @NotNull(message = "userId is required")
    private Long userId;

    @NotBlank(message = "nameClient is required")
    private String clientName;

    @NotNull(message = "plateId is required")
    private Long plateId;

    @NotNull(message = "quantity is required")
    @Min(value = 0, message = "the lower quantity is 0")
    private Integer quantity;
}
