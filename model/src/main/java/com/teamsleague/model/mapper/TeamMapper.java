package com.teamsleague.model.mapper;

import com.teamsleague.model.domain.entity.Team;
import com.teamsleague.model.persistence.model.TeamEntityDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PlayerMapper.class , SponsorMapper.class})
public interface TeamMapper {

    TeamMapper mapper = Mappers.getMapper(TeamMapper.class);

    @Mapping(target = "players")
    @Mapping(target = "sponsors")
    Team toTeam(TeamEntityDTO teamEntityDTO);

    List<Team> toTeamList(List<TeamEntityDTO> teamEntities);

    @Mapping(target = "players")
    @Mapping(target = "sponsors")
    TeamEntityDTO toTeamEntityDTO(Team team);

    List<TeamEntityDTO> toTeamEntityDTOList(List<Team> teams);
}
