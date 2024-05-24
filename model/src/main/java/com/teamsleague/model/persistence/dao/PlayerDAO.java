package com.teamsleague.model.persistence.dao;

import com.teamsleague.model.persistence.model.PlayerEntityDTO;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerDAO extends JpaRepository<PlayerEntityDTO, Integer> {

    @EntityGraph(attributePaths = "sponsors")
    PlayerEntityDTO findById(int id);
}
