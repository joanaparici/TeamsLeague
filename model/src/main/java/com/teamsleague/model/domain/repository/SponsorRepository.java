package com.teamsleague.model.domain.repository;

import com.teamsleague.model.domain.entity.Sponsor;

import java.util.List;
import java.util.Optional;

public interface SponsorRepository {
    List<Sponsor> findAllById(List<Integer> ids);

    Sponsor create(Sponsor sponsor);

    Sponsor update(int id, Sponsor sponsor);

    void delete(int id);

    Optional<Sponsor> findById(int id);
}
