package com.teamsleague.contract.model.team;

import com.teamsleague.contract.model.player.PlayerCreateDTO;
import com.teamsleague.contract.model.player.PlayerListDTO;
import com.teamsleague.contract.model.sponsor.SponsorListDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TeamCreateDTO {
    private String nombre;
    private String ubicacion;
    private String entrenador;
    private String capitan;
    private String categoria;
    private List<PlayerCreateDTO> playerList;
    private List<Integer> sponsorIdList;
}
