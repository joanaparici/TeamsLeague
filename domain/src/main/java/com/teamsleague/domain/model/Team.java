package com.teamsleague.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Team {
    private Integer id;
    private String nombre;
    private String ubicacion;
    private String entrenador;
    private String capitan;
    private String categoria;
    @ToString.Exclude
    private List<Player> players;
    @ToString.Exclude
    private List<Sponsor> sponsors;
}
