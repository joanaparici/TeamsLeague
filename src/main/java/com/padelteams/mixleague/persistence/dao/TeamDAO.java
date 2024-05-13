package com.padelteams.mixleague.persistence.dao;

import com.padelteams.mixleague.persistence.model.TeamEntityDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamDAO extends JpaRepository<TeamEntityDTO, Integer> {

}
