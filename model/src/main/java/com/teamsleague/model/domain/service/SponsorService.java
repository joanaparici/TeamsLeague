package com.teamsleague.model.domain.service;

import com.teamsleague.model.domain.entity.Sponsor;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public interface SponsorService {
    Sponsor create(Sponsor sponsor);

    Sponsor update(int id, Sponsor sponsor);

    void delete(int id);

    Optional<Sponsor> findById(int id);

    List<Sponsor> findAllById(List<Integer> ids);
}
