package com.arka.firstapi.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductUpdateDTO {

    @Min(value = 1, message = "Id be greater than 0")
    private Long id;
    @NotBlank(message = "Name is mandatory")
    @NotNull(message = "Name is mandatory")
    @NotEmpty(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Origin is mandatory")
    @NotNull(message = "Origin is mandatory")
    @NotEmpty(message = "Origin is mandatory")
    private String origin;

    @Min(value = 1, message = "Price Per Quantity Should be greater than 0")
    private double pricePerQuantity;
    @Min(value = 1, message = "Total Quantity Should be greater than 0")
    private long totalQuantity;
}
