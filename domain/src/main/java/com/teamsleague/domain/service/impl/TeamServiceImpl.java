package com.teamsleague.domain.service.impl;

import com.teamsleague.domain.model.Player;
import com.teamsleague.domain.model.Sponsor;
import com.teamsleague.domain.model.Team;
import com.teamsleague.domain.port.in.TeamService;
import com.teamsleague.domain.port.out.PlayerRepository;
import com.teamsleague.domain.port.out.SponsorRepository;
import com.teamsleague.domain.port.out.TeamRepository;

import java.util.*;
import java.util.stream.Collectors;

public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final SponsorRepository sponsorRepository;
    private final PlayerRepository playerRepository;

    public TeamServiceImpl(TeamRepository teamRepository, SponsorRepository sponsorRepository, PlayerRepository playerRepository) {
        this.teamRepository = teamRepository;
        this.sponsorRepository = sponsorRepository;
        this.playerRepository = playerRepository;
    }

    @Override
    public List<Team> getAll() {
        return teamRepository.getAll();
    }

    @Override
    public Optional<Team> findById(int id) {
        return teamRepository.findById(id);
    }

    @Override
    public Team addTeam(Team team, List<Player> playerList, List<Integer> sponsorIdList) {
        Team savedTeam = teamRepository.addTeam(team);

        List<Player> savedPlayers = playerList.stream()
                .peek(player -> player.setTeam(savedTeam))
                .map(playerRepository::addPlayer)
                .collect(Collectors.toList());

        savedTeam.setPlayers(savedPlayers);

        List<Sponsor> sponsorList = sponsorRepository.findAllById(sponsorIdList);
        savedTeam.setSponsors(sponsorList);

        validateSponsors(savedTeam);
        return teamRepository.addTeam(savedTeam);
    }

    @Override
    public Team updateTeam(int id, Team team, List<Player> playerList, List<Integer> sponsorIdList) {
        Team currentTeam = teamRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Team not found"));

        currentTeam.setNombre(team.getNombre());
        currentTeam.setCapitan(team.getCapitan());
        currentTeam.setEntrenador(team.getEntrenador());
        currentTeam.setCategoria(team.getCategoria());
        currentTeam.setUbicacion(team.getUbicacion());

        List<Player> updatedPlayers = new ArrayList<>();
        for (Player player : playerList) {
            player.setTeam(currentTeam);
            if (player.getId() != null && playerRepository.findById(player.getId()).isPresent()) {
                updatedPlayers.add(playerRepository.updatePlayer(player.getId(), player));
            } else {
                updatedPlayers.add(playerRepository.addPlayer(player));
            }
        }
        currentTeam.setPlayers(updatedPlayers);

        List<Sponsor> sponsorList = sponsorRepository.findAllById(sponsorIdList);
        currentTeam.setSponsors(sponsorList);

        validateSponsors(currentTeam);

        return teamRepository.updateTeam(id, currentTeam);
    }

    @Override
    public void deleteTeam(int id) {
        teamRepository.deleteTeam(id);
    }

    private void validateSponsors(Team team) {
        if (team.getSponsors() != null) {
            Set<String> industries = new HashSet<>();
            for (Sponsor sponsor : team.getSponsors()) {
                if (!industries.add(sponsor.getIndustria())) {
                    throw new IllegalArgumentException("A team cannot have sponsors from the same industry: " + sponsor.getIndustria());
                }
            }
        }
    }
}
