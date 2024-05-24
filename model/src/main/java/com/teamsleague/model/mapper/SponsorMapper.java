package com.teamsleague.model.mapper;

import com.teamsleague.model.domain.entity.Sponsor;
import com.teamsleague.model.persistence.model.SponsorEntityDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SponsorMapper {

    SponsorMapper mapper = Mappers.getMapper(SponsorMapper.class);

    @Mapping(target = "teams", ignore = true)
    Sponsor toSponsor(SponsorEntityDTO sponsorEntityDTO);

    List<Sponsor> toSponsorList(List<SponsorEntityDTO> sponsorEntities);

    SponsorEntityDTO toSponsorEntityDTO(Sponsor sponsor);

    List<SponsorEntityDTO> toSponsorEntityDTOList(List<Sponsor> sponsors);
}
