package com.padelteams.mixleague.persistence.impl;

import com.padelteams.mixleague.domain.entity.Team;
import com.padelteams.mixleague.domain.repository.TeamRepository;
import com.padelteams.mixleague.mapper.TeamMapper;
import com.padelteams.mixleague.persistence.dao.TeamDAO;
import com.padelteams.mixleague.persistence.model.TeamEntityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Repository
public class TeamRepositoryImpl implements TeamRepository {


    @Autowired
    private TeamDAO teamDAO;

    @Override
    public List<Team> getAll() {
        List<TeamEntityDTO> teamEntities;
        teamEntities = teamDAO.findAll();
        return TeamMapper.mapper.toTeamList(teamEntities);
    }

    @Override
    public Optional<Team> findById(int id) {
        return Optional.ofNullable(TeamMapper.mapper.toTeam(teamDAO.findById(id).orElse(null)));
    }

    @Override
    @Transactional
    public Team addTeam(Team Team) {
        TeamEntityDTO teamEntityDTO = TeamMapper.mapper.toTeamEntityDTO(Team);
        teamDAO.save(teamEntityDTO);
        return TeamMapper.mapper.toTeam(teamEntityDTO);
    }

    @Override
    public Team updateTeam(int id, Team Team) {
        TeamEntityDTO teamEntity = TeamMapper.mapper.toTeamEntityDTO(Team);
        teamEntity.setId(id);
        teamDAO.save(teamEntity);
        return TeamMapper.mapper.toTeam(teamEntity);
    }

    @Override
    public void deleteTeam(int id) {
        teamDAO.deleteById(id);
    }
}
