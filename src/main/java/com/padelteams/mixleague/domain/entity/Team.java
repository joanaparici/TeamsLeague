package com.padelteams.mixleague.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Team {
    private int id;
    private String nombre;
    private String ubicacion;
    private String entrenador;
    private String capitan;
    private String categoria;
}
