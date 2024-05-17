package com.teamsleague.model.persistence.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "jugadores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerEntityDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String posicion;

    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private TeamEntityDTO team;
}
