package com.teamsleague.model.domain.service.impl;

import com.teamsleague.model.domain.entity.Player;
import com.teamsleague.model.domain.entity.Sponsor;
import com.teamsleague.model.domain.entity.Team;
import com.teamsleague.model.domain.repository.PlayerRepository;
import com.teamsleague.model.domain.repository.SponsorRepository;
import com.teamsleague.model.domain.repository.TeamRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TeamServiceImplTest {

    @Mock
    private TeamRepository teamRepository;

    @Mock
    private SponsorRepository sponsorRepository;

    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private TeamServiceImpl teamService;

    private Team team;
    private Player player;
    private Sponsor sponsor;

    @BeforeEach
    void setUp() {
        team = new Team();
        team.setId(1);
        team.setNombre("Team A");

        player = new Player();
        player.setId(1);
        player.setNombre("Player A");

        sponsor = new Sponsor();
        sponsor.setId(1);
        sponsor.setNombre("Sponsor A");
        sponsor.setIndustria("Industry A");
    }

    @Test
    void getAll() {
        when(teamRepository.getAll()).thenReturn(Collections.singletonList(team));

        List<Team> teams = teamService.getAll();

        assertNotNull(teams);
        assertEquals(1, teams.size());
        verify(teamRepository, times(1)).getAll();
    }

    @Test
    void findById() {
        when(teamRepository.findById(1)).thenReturn(Optional.of(team));

        Optional<Team> foundTeam = teamService.findById(1);

        assertTrue(foundTeam.isPresent());
        assertEquals(team.getNombre(), foundTeam.get().getNombre());
        verify(teamRepository, times(1)).findById(1);
    }

    @Test
    void addTeam() {
        List<Player> players = Arrays.asList(player);
        List<Integer> sponsorIds = Arrays.asList(sponsor.getId());

        when(teamRepository.addTeam(any(Team.class))).thenReturn(team);
        when(playerRepository.addPlayer(any(Player.class))).thenReturn(player);
        when(sponsorRepository.findAllById(anyList())).thenReturn(Collections.singletonList(sponsor));

        Team savedTeam = teamService.addTeam(team, players, sponsorIds);

        assertNotNull(savedTeam);
        assertEquals(team.getNombre(), savedTeam.getNombre());
        assertEquals(1, savedTeam.getPlayers().size());
        assertEquals(1, savedTeam.getSponsors().size());

        verify(teamRepository, times(2)).addTeam(any(Team.class));
        verify(playerRepository, times(1)).addPlayer(any(Player.class));
        verify(sponsorRepository, times(1)).findAllById(anyList());
    }


    @Test
    void deleteTeam() {
        doNothing().when(teamRepository).deleteTeam(1);

        teamService.deleteTeam(1);

        verify(teamRepository, times(1)).deleteTeam(1);
    }
}
