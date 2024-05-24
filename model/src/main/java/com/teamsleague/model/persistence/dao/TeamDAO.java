package com.teamsleague.model.persistence.dao;

import com.teamsleague.model.persistence.model.TeamEntityDTO;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamDAO extends JpaRepository<TeamEntityDTO, Integer> {

    @EntityGraph(attributePaths = "sponsors")
    TeamEntityDTO findById(int id);
}
