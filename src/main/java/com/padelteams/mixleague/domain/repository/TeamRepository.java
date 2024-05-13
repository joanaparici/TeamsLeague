package com.padelteams.mixleague.domain.repository;

import com.padelteams.mixleague.domain.entity.Team;

import java.util.List;
import java.util.Optional;

public interface TeamRepository {

    List<Team> getAll();

    Optional<Team> findById(int id);

    Team addTeam(Team team);

    Team updateTeam(int id, Team team);

    void deleteTeam(int id);
}
