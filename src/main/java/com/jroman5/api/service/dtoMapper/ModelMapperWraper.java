package com.jroman5.api.service.dtoMapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperWraper {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
