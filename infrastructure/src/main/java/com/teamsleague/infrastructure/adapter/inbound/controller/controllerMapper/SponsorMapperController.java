package com.teamsleague.infrastructure.adapter.inbound.controller.controllerMapper;

import com.teamsleague.domain.model.Sponsor;
import com.teamsleague.infrastructure.adapter.inbound.modelWeb.sponsor.SponsorCreateDTO;
import com.teamsleague.infrastructure.adapter.inbound.modelWeb.sponsor.SponsorListDTO;
import com.teamsleague.infrastructure.adapter.inbound.modelWeb.sponsor.SponsorUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface SponsorMapperController {
    Sponsor toSponsor(SponsorListDTO sponsorListDTO);

    SponsorListDTO toSponsorListDTO(Sponsor sponsor);

    Sponsor sponsorCreateToSponsor(SponsorCreateDTO sponsorCreateDTO);

    Sponsor sponsorUpdateToSponsor(SponsorUpdateDTO sponsorUpdateDTO);

    @Mapping(target = "teams", ignore = true)
    Sponsor toSponsor(SponsorUpdateDTO sponsorUpdateDTO);
}