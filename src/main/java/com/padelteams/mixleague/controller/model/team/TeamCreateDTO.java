package com.padelteams.mixleague.controller.model.team;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TeamCreateDTO {
    private String nombre;
    private String ubicacion;
    private String entrenador;
    private String capitan;
    private String categoria;
}
