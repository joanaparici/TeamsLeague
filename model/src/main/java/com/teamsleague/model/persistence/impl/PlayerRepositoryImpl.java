package com.teamsleague.model.persistence.impl;

import com.teamsleague.model.domain.entity.Player;
import com.teamsleague.model.domain.entity.Team;
import com.teamsleague.model.domain.repository.PlayerRepository;
import com.teamsleague.model.mapper.PlayerMapper;
import com.teamsleague.model.persistence.dao.PlayerDAO;
import com.teamsleague.model.persistence.model.PlayerEntityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PlayerRepositoryImpl implements PlayerRepository {

    @Autowired
    PlayerDAO playerDAO;

    @Autowired
    PlayerMapper mapper;

    @Override
    public Optional<Player> findById(int id) {
        return Optional.ofNullable(mapper.toPlayer(playerDAO.findById(id)));
    }

    @Override
    public List<Player> findAllById(List<Integer> ids) {
        List<PlayerEntityDTO> playerEntities = playerDAO.findAllById(ids);

        return playerEntities.stream()
                .map(mapper::toPlayer)
                .collect(Collectors.toList());
    }

    @Override
    public Player addPlayer(Player player) {
        PlayerEntityDTO playerEntityDTO = mapper.toPlayerEntityDTO(player);
        playerDAO.save(playerEntityDTO);
        return mapper.toPlayer(playerEntityDTO);
    }

    public Player updatePlayer(int id, Player player) {
        PlayerEntityDTO playerEntityDTO = mapper.toPlayerEntityDTO(player);
        player.setId(id);
        playerDAO.save(playerEntityDTO);
        return mapper.toPlayer(playerEntityDTO);
    }
}