package com.teamsleague.infrastructure.adapter.inbound.controller.controllerMapper;


import com.teamsleague.domain.model.Player;
import com.teamsleague.infrastructure.adapter.inbound.modelWeb.player.PlayerCreateDTO;
import com.teamsleague.infrastructure.adapter.inbound.modelWeb.player.PlayerListDTO;
import com.teamsleague.infrastructure.adapter.inbound.modelWeb.player.PlayerUpdateDTO;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper
public interface PlayerMapperController {

    Player playerCreateDTOtoPlayer(PlayerCreateDTO playerCreateDTO);

    Player playerUpdateDTOtoPlayer(PlayerUpdateDTO playerUpdateDTO);

    PlayerListDTO toPlayerListDTO(Player player);

    Player toPlayer(PlayerListDTO playerListDTO);

    List<Player> toPlayerList(List<PlayerListDTO> playerListDTOList);
}

