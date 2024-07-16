package com.teamsleague.infrastructure.adapter.outbound.persistence.repository;

import com.teamsleague.domain.model.Player;
import com.teamsleague.domain.port.out.PlayerRepository;
import com.teamsleague.infrastructure.adapter.outbound.persistence.dao.PlayerDAO;
import com.teamsleague.infrastructure.adapter.outbound.persistence.model.PlayerEntityDTO;
import com.teamsleague.infrastructure.adapter.outbound.persistence.mapper.PlayerMapper;
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