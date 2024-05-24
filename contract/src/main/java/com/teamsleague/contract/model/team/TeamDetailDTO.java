package com.teamsleague.contract.model.team;

import com.teamsleague.contract.model.player.PlayerListDTO;
import com.teamsleague.contract.model.sponsor.SponsorListDTO;
import com.teamsleague.model.domain.entity.Sponsor;
import com.teamsleague.model.domain.entity.Team;
import com.teamsleague.model.persistence.model.TeamEntityDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TeamDetailDTO {
    private Integer id;
    private String nombre;
    private String ubicacion;
    private String entrenador;
    private String capitan;
    private String categoria;
    private List<PlayerListDTO> players;
    private List<SponsorListDTO> sponsors;
}
