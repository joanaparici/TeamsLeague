package com.teamsleague.infrastructure.adapter.outbound.persistence.repository;


import com.teamsleague.domain.model.Team;
import com.teamsleague.domain.port.out.TeamRepository;
import com.teamsleague.infrastructure.adapter.outbound.persistence.dao.TeamDAO;
import com.teamsleague.infrastructure.adapter.outbound.persistence.model.TeamEntityDTO;
import com.teamsleague.infrastructure.adapter.outbound.persistence.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Repository
public class TeamRepositoryImpl implements TeamRepository {

    private final TeamMapper mapper;
    private final TeamDAO teamDAO;

    public TeamRepositoryImpl(TeamMapper mapper, TeamDAO teamDAO) {
        this.mapper = mapper;
        this.teamDAO = teamDAO;
    }

    @Override
    public List<Team> getAll() {
        List<TeamEntityDTO> teamEntities;
        teamEntities = teamDAO.findAll();
        return mapper.toTeamList(teamEntities);
    }

    @Override
    public Optional<Team> findById(int id) {
        return Optional.ofNullable(mapper.toTeam(teamDAO.findById(id)));
    }

    @Override
    @Transactional
    public Team addTeam(Team team) {
        TeamEntityDTO teamEntityDTO = mapper.toTeamEntityDTO(team);
        teamDAO.save(teamEntityDTO);
        return mapper.toTeam(teamEntityDTO);
    }

    @Override
    public Team updateTeam(int id, Team team) {
        TeamEntityDTO teamEntity = mapper.toTeamEntityDTO(team);
        teamEntity.setId(id);
        teamDAO.save(teamEntity);
        return mapper.toTeam(teamEntity);
    }

    @Override
    public void deleteTeam(int id) {
        teamDAO.deleteById(id);
    }
}
