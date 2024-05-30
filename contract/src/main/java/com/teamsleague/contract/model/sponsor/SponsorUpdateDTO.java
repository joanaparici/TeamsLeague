package com.teamsleague.contract.model.sponsor;

import lombok.Data;

@Data
public class SponsorUpdateDTO {
    private Integer id;
    private String nombre;
    private String industria;
    private Integer version;
}
