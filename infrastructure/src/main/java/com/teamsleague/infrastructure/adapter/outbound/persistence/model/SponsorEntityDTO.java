package com.teamsleague.infrastructure.adapter.outbound.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "patrocinadores")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "teams"})
public class SponsorEntityDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String industria;

    @Version
    private Integer version = 0;

    private Boolean deleted = false;

    @ManyToMany(mappedBy = "sponsors", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<TeamEntityDTO> teams;
}
