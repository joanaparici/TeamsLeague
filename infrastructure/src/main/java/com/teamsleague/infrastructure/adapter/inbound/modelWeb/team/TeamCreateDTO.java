package com.teamsleague.infrastructure.adapter.inbound.modelWeb.team;

import com.teamsleague.infrastructure.adapter.inbound.modelWeb.player.PlayerCreateDTO;
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
