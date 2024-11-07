package com.aptproject.SpringLibraryProject.library.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.config.Configuration.AccessLevel;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT) // должно строго совпадать
                .setFieldMatchingEnabled(true) // разрешили совпадение по полям
                .setSkipNullEnabled(true) // пропускаем поля, если они = null
                .setFieldAccessLevel(AccessLevel.PRIVATE);
        return modelMapper;
    }
}
