package com.teamsleague.model.persistence.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "equipos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamEntityDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String ubicacion;
    private String entrenador;
    private String capitan;
    private String categoria;

    @OneToMany(mappedBy = "team")
    private List<PlayerEntityDTO> players;
}
