package com.teamsleague.model.domain.service.impl;

import com.teamsleague.model.domain.entity.Team;
import com.teamsleague.model.domain.repository.TeamRepository;
import com.teamsleague.model.domain.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public List<Team> getAll() {
        return teamRepository.getAll();
    }

    @Override
    public Optional<Team> findById(int id) {
        return teamRepository.findById(id);
    }

    @Override
    public Team addTeam(Team team) {
        return teamRepository.addTeam(team);
    }

    @Override
    public Team updateTeam(int id, Team team) {
        return teamRepository.updateTeam(id, team);
    }

    @Override
    public void deleteTeam(int id) {
        teamRepository.deleteTeam(id);
    }
}
