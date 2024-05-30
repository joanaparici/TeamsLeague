package com.teamsleague.model.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Sponsor {
    private Integer id;
    private String nombre;
    private String industria;
    private Integer version;
    private Boolean deleted;
    @ToString.Exclude
    private List<Team> teams;
}
