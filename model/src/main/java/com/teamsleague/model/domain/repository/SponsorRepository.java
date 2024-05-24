package com.teamsleague.model.domain.repository;

import com.teamsleague.model.domain.entity.Sponsor;

import java.util.List;

public interface SponsorRepository {

    List<Sponsor> findAllById(List<Integer> ids);
}
