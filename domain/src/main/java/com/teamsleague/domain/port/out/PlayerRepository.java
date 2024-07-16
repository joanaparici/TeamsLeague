package com.teamsleague.domain.port.out;

import com.teamsleague.domain.model.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository {

    Optional<Player> findById(int id);

    List<Player> findAllById(List<Integer> ids);

    Player addPlayer(Player player);

    Player updatePlayer(int id, Player player);
}
