package com.padelteams.mixleague.mapper;

import com.padelteams.mixleague.controller.model.team.TeamCreateDTO;
import com.padelteams.mixleague.controller.model.team.TeamDetailDTO;
import com.padelteams.mixleague.controller.model.team.TeamListDTO;
import com.padelteams.mixleague.controller.model.team.TeamUpdateDTO;
import com.padelteams.mixleague.domain.entity.Team;
import com.padelteams.mixleague.persistence.model.TeamEntityDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeamMapper {

    TeamMapper mapper = Mappers.getMapper(TeamMapper.class);

    Team toTeam(TeamEntityDTO teamEntityDTO);

    List<Team> toTeamList(List<TeamEntityDTO> teamEntities);

    TeamListDTO toTeamListDTO(Team team);

    TeamEntityDTO toTeamEntityDTO(Team team);

    TeamDetailDTO toTeamDetailDTO (Team team);

    Team TeamCreateDTOtoTeam (TeamCreateDTO teamCreateDTO);

    Team TeamUpdateDTOtoTeam (TeamUpdateDTO teamUpdateDTO);
}
