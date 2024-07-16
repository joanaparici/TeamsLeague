package com.teamsleague.infrastructure.adapter.inbound.modelWeb.team;

import com.teamsleague.infrastructure.adapter.inbound.modelWeb.player.PlayerUpdateDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TeamUpdateDTO {
    private String nombre;
    private String ubicacion;
    private String entrenador;
    private String capitan;
    private String categoria;
    private List<PlayerUpdateDTO> newPlayersList;
    private List<Integer> sponsorIdList;
}
