package com.teamsleague.model.mapper;

import com.teamsleague.model.domain.entity.Player;
import com.teamsleague.model.persistence.model.PlayerEntityDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    PlayerMapper mapper = Mappers.getMapper(PlayerMapper.class);

    @Mapping(target = "team", ignore = true)
    Player toPlayer(PlayerEntityDTO playerEntityDTO);

    List<Player> toPlayerList(List<PlayerEntityDTO> playerEntities);

    PlayerEntityDTO toPlayerEntityDTO(Player player);

    List<PlayerEntityDTO> toPlayerEntityDTOList(List<Player> players);
}
