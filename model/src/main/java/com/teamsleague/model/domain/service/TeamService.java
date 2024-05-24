package com.teamsleague.model.domain.service;

import com.teamsleague.model.domain.entity.Player;
import com.teamsleague.model.domain.entity.Team;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TeamService {
    List<Team> getAll();

    Optional<Team> findById(int id);

    Team addTeam(Team Team, List<Player> playerList, List<Integer> sponsorIdList);

    Team updateTeam(int id, Team team, List<Player> playerList, List<Integer> sponsorIdList);

    void deleteTeam(int id);
}
