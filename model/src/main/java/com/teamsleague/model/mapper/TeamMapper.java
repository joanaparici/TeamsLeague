package com.teamsleague.model.mapper;

import com.teamsleague.model.domain.entity.Team;
import com.teamsleague.model.persistence.model.TeamEntityDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring")
public interface TeamMapper {

    TeamMapper mapper = Mappers.getMapper(TeamMapper.class);

    Team toTeam(TeamEntityDTO teamEntityDTO);

    List<Team> toTeamList(List<TeamEntityDTO> teamEntities);

    TeamEntityDTO toTeamEntityDTO(Team team);


}
