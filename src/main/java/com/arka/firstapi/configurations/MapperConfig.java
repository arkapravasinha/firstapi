package com.arka.firstapi.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig
{
    @Bean
    public ModelMapper getModelMapperConfig()
    {
        return new ModelMapper();
    }
}
