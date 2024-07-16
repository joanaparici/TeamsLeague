package com.teamsleague.infrastructure.adapter.inbound.modelWeb.sponsor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SponsorListDTO {
    private Integer id;
    private String nombre;
    private String industria;
    private Integer version;
}
