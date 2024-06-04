package com.teamsleague.infrastructure.adapter.outbound.persistence.dao;


import com.teamsleague.infrastructure.adapter.outbound.persistence.model.PlayerEntityDTO;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PlayerDAO extends JpaRepository<PlayerEntityDTO, Integer> {

    @EntityGraph(attributePaths = "sponsors")
    PlayerEntityDTO findById(int id);
}
