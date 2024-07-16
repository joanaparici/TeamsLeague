package com.teamsleague.domain.port.in;


import java.util.List;
import java.util.Optional;

import com.teamsleague.domain.model.Sponsor;

public interface SponsorService {
    Sponsor create(Sponsor sponsor);

    Sponsor update(int id, Sponsor sponsor);

    void delete(int id);

    Optional<Sponsor> findById(int id);

    List<Sponsor> findAllById(List<Integer> ids);
}
