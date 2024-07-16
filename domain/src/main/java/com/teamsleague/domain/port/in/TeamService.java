package com.teamsleague.domain.port.in;

import com.teamsleague.domain.model.Player;
import com.teamsleague.domain.model.Team;

import java.util.List;
import java.util.Optional;

public interface TeamService {
    List<Team> getAll();

    Optional<Team> findById(int id);

    Team addTeam(Team Team, List<Player> playerList, List<Integer> sponsorIdList);

    Team updateTeam(int id, Team team, List<Player> playerList, List<Integer> sponsorIdList);

    void deleteTeam(int id);
}
