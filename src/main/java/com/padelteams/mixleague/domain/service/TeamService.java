package com.padelteams.mixleague.domain.service;

import com.padelteams.mixleague.domain.entity.Team;

import java.util.List;
import java.util.Optional;

public interface TeamService {
    List<Team> getAll();

    Optional<Team> findById(int id);

    Team addTeam(Team Team);

    Team updateTeam(int id, Team Team);

    void deleteTeam(int id);
}
