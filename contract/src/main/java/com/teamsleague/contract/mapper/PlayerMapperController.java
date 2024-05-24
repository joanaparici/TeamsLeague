package com.teamsleague.contract.mapper;

import com.teamsleague.contract.model.player.PlayerCreateDTO;
import com.teamsleague.contract.model.player.PlayerListDTO;
import com.teamsleague.contract.model.player.PlayerUpdateDTO;
import com.teamsleague.model.domain.entity.Player;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlayerMapperController {

    Player playerCreateDTOtoPlayer(PlayerCreateDTO playerCreateDTO);

    Player playerUpdateDTOtoPlayer(PlayerUpdateDTO playerUpdateDTO);

    PlayerListDTO toPlayerListDTO(Player player);

    Player toPlayer(PlayerListDTO playerListDTO);

    List<Player> toPlayerList(List<PlayerListDTO> playerListDTOList);
}

