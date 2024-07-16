package com.teamsleague.infrastructure.config;

import com.teamsleague.domain.port.in.SponsorService;
import com.teamsleague.domain.port.in.TeamService;
import com.teamsleague.domain.port.out.PlayerRepository;
import com.teamsleague.domain.port.out.SponsorRepository;
import com.teamsleague.domain.port.out.TeamRepository;
import com.teamsleague.domain.service.impl.SponsorServiceImpl;
import com.teamsleague.domain.service.impl.TeamServiceImpl;
import com.teamsleague.infrastructure.adapter.inbound.controller.controllerMapper.PlayerMapperController;
import com.teamsleague.infrastructure.adapter.inbound.controller.controllerMapper.SponsorMapperController;
import com.teamsleague.infrastructure.adapter.inbound.controller.controllerMapper.TeamMapperController;
import com.teamsleague.infrastructure.adapter.outbound.persistence.dao.TeamDAO;
import com.teamsleague.infrastructure.adapter.outbound.persistence.mapper.TeamMapper;
import com.teamsleague.infrastructure.adapter.outbound.persistence.repository.PlayerRepositoryImpl;
import com.teamsleague.infrastructure.adapter.outbound.persistence.repository.SponsorRepositoryImpl;
import com.teamsleague.infrastructure.adapter.outbound.persistence.repository.TeamRepositoryImpl;
import com.teamsleague.infrastructure.adapter.inbound.jms.JMSReceiver;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ManualDependencyInjectionConfig {

    @Bean
    public SponsorRepository sponsorRepository() {
        return new SponsorRepositoryImpl();
    }

    @Bean
    public TeamRepository teamRepository(TeamMapper teamMapper, TeamDAO teamDAO) {
        return new TeamRepositoryImpl(teamMapper, teamDAO);
    }

    @Bean
    public PlayerRepository playerRepository() {
        return new PlayerRepositoryImpl();
    }

    @Bean
    public SponsorService sponsorService(SponsorRepository sponsorRepository) {
        return new SponsorServiceImpl(sponsorRepository);
    }

    @Bean
    public TeamService teamService(TeamRepository teamRepository, SponsorRepository sponsorRepository, PlayerRepository playerRepository) {
        return new TeamServiceImpl(teamRepository, sponsorRepository, playerRepository);
    }

    @Bean
    public TeamMapperController teamMapperController() {
        return Mappers.getMapper(TeamMapperController.class);
    }

    @Bean
    public PlayerMapperController playerMapperController() {
        return Mappers.getMapper(PlayerMapperController.class);
    }

    @Bean
    public SponsorMapperController sponsorMapperController() {
        return Mappers.getMapper(SponsorMapperController.class);
    }

    @Bean
    public JMSReceiver jmsReceiver(SponsorService sponsorService, SponsorMapperController sponsorMapperController) {
        return new JMSReceiver(sponsorService, sponsorMapperController);
    }
}
