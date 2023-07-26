package com.arka.firstapi.services;

import com.arka.firstapi.datamodels.Product;
import com.arka.firstapi.exceptions.ProductNotFoundException;
import com.arka.firstapi.models.ProductCreateDTO;
import com.arka.firstapi.models.ProductResponseDTO;
import com.arka.firstapi.models.ProductUpdateDTO;

import java.util.Collection;

public interface ProductService
{
    public abstract ProductResponseDTO createProduct(ProductCreateDTO product);
    public abstract ProductResponseDTO updateProduct(ProductUpdateDTO product) throws ProductNotFoundException;
    public abstract void deleteProduct(Long id) throws ProductNotFoundException;
    public abstract Collection<ProductResponseDTO> getProducts();
    public abstract ProductResponseDTO getProduct(Long id) throws ProductNotFoundException;
}
