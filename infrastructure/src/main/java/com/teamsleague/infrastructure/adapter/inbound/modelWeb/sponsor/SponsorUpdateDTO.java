package com.teamsleague.infrastructure.adapter.inbound.modelWeb.sponsor;

import lombok.Data;

@Data
public class SponsorUpdateDTO {
    private Integer id;
    private String nombre;
    private String industria;
    private Integer version;
}
