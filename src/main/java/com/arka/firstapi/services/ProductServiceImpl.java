package com.arka.firstapi.services;

import com.arka.firstapi.datamodels.Product;
import com.arka.firstapi.exceptions.ProductNotFoundException;
import com.arka.firstapi.models.ProductCreateDTO;
import com.arka.firstapi.models.ProductResponseDTO;
import com.arka.firstapi.models.ProductUpdateDTO;
import com.arka.firstapi.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository _productRepository;

    @Autowired
    private ModelMapper _modelMapper;


    @Override
    public ProductResponseDTO createProduct(ProductCreateDTO product) {

        var data=_modelMapper.map(product,Product.class);
        return _modelMapper.map(_productRepository.save(data), ProductResponseDTO.class);
    }

    @Override
    public ProductResponseDTO updateProduct(ProductUpdateDTO product) throws ProductNotFoundException {
        if(_productRepository.existsById(product.getId())) {
            return _modelMapper.map(_productRepository.save(_modelMapper.map(product,Product.class)),ProductResponseDTO.class);
        }
        else
        {
            throw new ProductNotFoundException(product.getId());
        }
    }

    @Override
    public void deleteProduct(Long id) throws ProductNotFoundException{
        Product toDelete=_productRepository.findById(id).orElseThrow(()->new ProductNotFoundException(id));

        _productRepository.delete(toDelete);
    }


    @Override
    public Collection<ProductResponseDTO> getProducts() {
        var data= _productRepository.findAll();
        return _modelMapper.map(data, new TypeToken<Collection<ProductResponseDTO>>(){}.getType());
    }

    @Override
    public ProductResponseDTO getProduct(Long id) throws ProductNotFoundException {
        return _modelMapper.map(_productRepository.findById(id).orElseThrow(()->new ProductNotFoundException(id)),ProductResponseDTO.class);
    }
}
