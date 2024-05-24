package com.teamsleague.contract.mapper;

import com.teamsleague.model.domain.entity.Team;
import com.teamsleague.contract.model.team.TeamCreateDTO;
import com.teamsleague.contract.model.team.TeamDetailDTO;
import com.teamsleague.contract.model.team.TeamListDTO;
import com.teamsleague.contract.model.team.TeamUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {PlayerMapperController.class, SponsorMapperController.class})
public interface TeamMapperController {

    TeamListDTO toTeamListDTO(Team team);

    TeamDetailDTO toTeamDetailDTO(Team team);

    Team TeamCreateDTOtoTeam(TeamCreateDTO teamCreateDTO);

    Team TeamUpdateDTOtoTeam(TeamUpdateDTO teamUpdateDTO);
}

