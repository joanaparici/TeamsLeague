package com.teamsleague.contract.mapper;

import com.teamsleague.contract.model.sponsor.SponsorCreateDTO;
import com.teamsleague.contract.model.sponsor.SponsorListDTO;
import com.teamsleague.contract.model.sponsor.SponsorUpdateDTO;
import com.teamsleague.model.domain.entity.Sponsor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SponsorMapperController {
    Sponsor toSponsor(SponsorListDTO sponsorListDTO);

    SponsorListDTO toSponsorListDTO(Sponsor sponsor);

    Sponsor sponsorCreateToSponsor(SponsorCreateDTO sponsorCreateDTO);

    Sponsor sponsorUpdateToSponsor(SponsorUpdateDTO sponsorUpdateDTO);

    @Mapping(target = "teams", ignore = true)
    Sponsor toSponsor(SponsorUpdateDTO sponsorUpdateDTO);
}