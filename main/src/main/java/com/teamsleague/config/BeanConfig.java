package com.teamsleague.config;

import com.teamsleague.contract.mapper.TeamMapperController;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public TeamMapperController teamMapperController() {
        return Mappers.getMapper(TeamMapperController.class);
    }
}
