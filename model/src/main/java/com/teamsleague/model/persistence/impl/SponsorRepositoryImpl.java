package com.teamsleague.model.persistence.impl;

import com.teamsleague.model.domain.entity.Sponsor;
import com.teamsleague.model.domain.repository.SponsorRepository;
import com.teamsleague.model.mapper.SponsorMapper;
import com.teamsleague.model.persistence.dao.SponsorDAO;
import com.teamsleague.model.persistence.model.SponsorEntityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
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

    @Override
    public Sponsor create(Sponsor sponsor) {
        SponsorEntityDTO entity = mapper.toSponsorEntityDTO(sponsor);
        SponsorEntityDTO savedEntity = sponsorDAO.save(entity);
        return mapper.toSponsor(savedEntity);
    }

    @Override
    public Sponsor update(int id, Sponsor sponsor) {
        SponsorEntityDTO entity = mapper.toSponsorEntityDTO(sponsor);
        entity.setId(id);
        SponsorEntityDTO updatedEntity = sponsorDAO.save(entity);
        return mapper.toSponsor(updatedEntity);
    }

    @Override
    public void delete(int id) {
        SponsorEntityDTO entity = sponsorDAO.findById(id).orElseThrow(() -> new IllegalArgumentException("Sponsor not found"));
        entity.setDeleted(true);
        sponsorDAO.save(entity);
    }

    @Override
    public Optional<Sponsor> findById(int id) {
        return sponsorDAO.findById(id)
                .filter(sponsor -> !sponsor.getDeleted())
                .map(mapper::toSponsor);
    }
}
