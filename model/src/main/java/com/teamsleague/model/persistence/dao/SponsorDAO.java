package com.teamsleague.model.persistence.dao;

import com.teamsleague.model.persistence.model.SponsorEntityDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SponsorDAO extends JpaRepository<SponsorEntityDTO, Integer> {
}
