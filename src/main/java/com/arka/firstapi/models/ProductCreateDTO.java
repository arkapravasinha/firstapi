package com.arka.firstapi.models;

import jakarta.validation.constraints.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateDTO {
    @NotBlank(message="Name is mandatory")
    @NotNull(message="Name is mandatory")
    @NotEmpty(message="Name is mandatory")
    private String name;

    @NotBlank(message="Origin is mandatory")
    @NotNull(message="Origin is mandatory")
    @NotEmpty(message="Origin is mandatory")
    private String origin;

    @Min(value = 1,message = "Price Per Quantity Should be greater than 0")
    private double pricePerQuantity;
    @Min(value = 1,message = "Total Quantity Should be greater than 0")
    private long totalQuantity;
}

