package com.teamsleague.infrastructure.adapter.inbound.modelWeb.team;

import com.teamsleague.infrastructure.adapter.inbound.modelWeb.player.PlayerListDTO;
import com.teamsleague.infrastructure.adapter.inbound.modelWeb.sponsor.SponsorListDTO;
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
