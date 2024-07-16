package com.teamsleague.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
public class Player {
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String genero;
    private String posicion;
    @ToString.Exclude
    private Team team;
}
