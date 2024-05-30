package com.teamsleague.model.persistence.dao;

import com.teamsleague.model.persistence.model.SponsorEntityDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SponsorDAO extends JpaRepository<SponsorEntityDTO, Integer> {
    List<SponsorEntityDTO> findByDeletedFalse();
}
