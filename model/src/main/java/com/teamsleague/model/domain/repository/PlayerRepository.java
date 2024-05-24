package com.teamsleague.model.domain.repository;

import com.teamsleague.model.domain.entity.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository {

    Optional<Player> findById(int id);

    List<Player> findAllById(List<Integer> ids);

    Player addPlayer(Player player);

    Player updatePlayer(int id, Player player);
}
