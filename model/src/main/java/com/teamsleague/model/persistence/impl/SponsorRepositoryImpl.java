package com.teamsleague.model.persistence.impl;

import com.teamsleague.model.domain.entity.Sponsor;
import com.teamsleague.model.domain.repository.SponsorRepository;
import com.teamsleague.model.mapper.SponsorMapper;
import com.teamsleague.model.persistence.dao.SponsorDAO;
import com.teamsleague.model.persistence.model.SponsorEntityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SponsorRepositoryImpl implements SponsorRepository {

    @Autowired
    SponsorDAO sponsorDAO;

    @Autowired
    SponsorMapper mapper;

    @Override
    public List<Sponsor> findAllById(List<Integer> ids) {
        List<SponsorEntityDTO> sponsorEntities = sponsorDAO.findAllById(ids);

        return sponsorEntities.stream()
                .map(mapper::toSponsor)
                .collect(Collectors.toList());
    }
}
