package com.arka.firstapi.models;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDTO extends RepresentationModel<ProductResponseDTO>
{
    private Long id;
    private String name;
    private String origin;
    private double pricePerQuantity;
    private long totalQuantity;
}
