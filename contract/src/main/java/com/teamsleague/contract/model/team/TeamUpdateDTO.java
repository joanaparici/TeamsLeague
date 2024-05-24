package com.teamsleague.contract.model.team;

import com.teamsleague.contract.model.player.PlayerUpdateDTO;
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
