package com.teamsleague.contract.mapper;

import com.teamsleague.contract.model.sponsor.SponsorListDTO;
import com.teamsleague.model.domain.entity.Sponsor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SponsorMapperController {
    Sponsor toSponsor(SponsorListDTO sponsorListDTO);

    SponsorListDTO toSponsorListDTO(Sponsor sponsor);
}