package com.teamsleague.infrastructure.adapter.outbound.persistence.dao;


import com.teamsleague.infrastructure.adapter.outbound.persistence.model.TeamEntityDTO;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TeamDAO extends JpaRepository<TeamEntityDTO, Integer> {

    @EntityGraph(attributePaths = "sponsors")
    TeamEntityDTO findById(int id);
}
