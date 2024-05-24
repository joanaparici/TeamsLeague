package com.teamsleague.contract.controller;

import com.teamsleague.contract.mapper.PlayerMapperController;
import com.teamsleague.contract.mapper.SponsorMapperController;
import com.teamsleague.model.domain.entity.Player;
import com.teamsleague.model.domain.entity.Sponsor;
import com.teamsleague.model.domain.entity.Team;
import com.teamsleague.model.domain.service.TeamService;
import com.teamsleague.contract.mapper.TeamMapperController;
import com.teamsleague.contract.model.team.TeamCreateDTO;
import com.teamsleague.contract.model.team.TeamDetailDTO;
import com.teamsleague.contract.model.team.TeamListDTO;
import com.teamsleague.contract.model.team.TeamUpdateDTO;
import com.teamsleague.contract.http_response.Response;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(TeamController.TEAMS)
public class TeamController {

    public static final String TEAMS = "/teams";

    private final TeamService teamService;
    private final TeamMapperController teamMapperController;
    private final PlayerMapperController playerMapperController;
    private final SponsorMapperController sponsorMapperController;

    public TeamController(TeamService teamService, TeamMapperController teamMapperController, PlayerMapperController playerMapperController, SponsorMapperController sponsorMapperController, PlayerMapperController playerMapperController1, SponsorMapperController sponsorMapperController1) {
        this.teamService = teamService;
        this.teamMapperController = teamMapperController;
        this.playerMapperController = playerMapperController1;
        this.sponsorMapperController = sponsorMapperController1;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Response getAll() {
        List<Team> teams = teamService.getAll();
        List<TeamListDTO> teamDTO = teams.stream()
                .map(teamMapperController::toTeamListDTO)
                .toList();
        return Response.builder()
                .data(teamDTO)
                .build();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Response getTeam(@PathVariable("id") int id) {
        Optional<Team> team = teamService.findById(id);
        TeamDetailDTO teamWeb = teamMapperController.toTeamDetailDTO(team.orElse(null));
        return Response.builder()
                .data(teamWeb)
                .build();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Response addTeam(@RequestBody TeamCreateDTO teamCreateWeb) {
        Team team = teamMapperController.TeamCreateDTOtoTeam(teamCreateWeb);

        List<Player> playerList = teamCreateWeb.getPlayerList().stream()
                .map(playerMapperController::playerCreateDTOtoPlayer)
                .toList();

       Team addedTeam = teamService.addTeam(team, playerList, teamCreateWeb.getSponsorIdList());
        TeamDetailDTO teamWeb = teamMapperController.toTeamDetailDTO(addedTeam);

        return Response.builder()
                .data(teamWeb)
                .build();
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public Response updateTeam(@PathVariable("id") int id, @RequestBody TeamUpdateDTO teamUpdateWeb) {
        Team team = teamMapperController.TeamUpdateDTOtoTeam(teamUpdateWeb);

        List<Player> playerList = teamUpdateWeb.getNewPlayersList().stream()
                .map(playerMapperController::playerUpdateDTOtoPlayer)
                .toList();

        Team updatedTeam = teamService.updateTeam(id, team, playerList, teamUpdateWeb.getSponsorIdList());

        TeamDetailDTO teamWeb = teamMapperController.toTeamDetailDTO(updatedTeam);

        return Response.builder()
                .data(teamWeb)
                .build();
    }


    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public Response deleteTeam(@PathVariable("id") int id) {
        teamService.deleteTeam(id);
        return Response.builder()
                .data("Team eliminado con id: " + id)
                .build();
    }
}
