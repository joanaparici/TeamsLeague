package com.teamsleague.infrastructure.adapter.inbound.controller.controllerMapper;

import com.teamsleague.domain.model.Team;
import com.teamsleague.infrastructure.adapter.inbound.modelWeb.team.TeamCreateDTO;
import com.teamsleague.infrastructure.adapter.inbound.modelWeb.team.TeamDetailDTO;
import com.teamsleague.infrastructure.adapter.inbound.modelWeb.team.TeamListDTO;
import com.teamsleague.infrastructure.adapter.inbound.modelWeb.team.TeamUpdateDTO;
import org.mapstruct.Mapper;

@Mapper(uses = {PlayerMapperController.class, SponsorMapperController.class})
public interface TeamMapperController {

    TeamListDTO toTeamListDTO(Team team);

    TeamDetailDTO toTeamDetailDTO(Team team);

    Team TeamCreateDTOtoTeam(TeamCreateDTO teamCreateDTO);

    Team TeamUpdateDTOtoTeam(TeamUpdateDTO teamUpdateDTO);
}

