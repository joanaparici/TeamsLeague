package com.teamsleague.model.persistence.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "equipos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamEntityDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String ubicacion;
    private String entrenador;
    private String capitan;
    private String categoria;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<PlayerEntityDTO> players;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "equipos_patrocinadores",
            joinColumns = @JoinColumn(name = "equipo_id"),
            inverseJoinColumns = @JoinColumn(name = "patrocinador_id")
    )
    @ToString.Exclude
    private List<SponsorEntityDTO> sponsors;
}
