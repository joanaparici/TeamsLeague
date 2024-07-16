package com.teamsleague.infrastructure.adapter.outbound.persistence.dao;


import com.teamsleague.infrastructure.adapter.outbound.persistence.model.SponsorEntityDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SponsorDAO extends JpaRepository<SponsorEntityDTO, Integer> {
    List<SponsorEntityDTO> findByDeletedFalse();
}
