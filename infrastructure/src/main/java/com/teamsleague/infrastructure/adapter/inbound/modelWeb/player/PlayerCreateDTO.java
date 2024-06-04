package com.teamsleague.infrastructure.adapter.inbound.modelWeb.player;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PlayerCreateDTO {
    private String nombre;
    private String apellido;
    private Integer edad;
    private String genero;
    private String posicion;
}
