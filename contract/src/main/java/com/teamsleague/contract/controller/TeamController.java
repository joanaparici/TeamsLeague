package com.teamsleague.contract.controller;

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

@RestController
@RequestMapping(TeamController.TEAMS)
public class TeamController {

    public static final String TEAMS = "/teams";

    private final TeamService teamService;
    private final TeamMapperController teamMapperController;

    public TeamController(TeamService teamService, TeamMapperController teamMapperController) {
        this.teamService = teamService;
        this.teamMapperController = teamMapperController;
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
        teamService.addTeam(team);
        TeamDetailDTO teamWeb = teamMapperController.toTeamDetailDTO(team);
        return Response.builder()
                .data(teamWeb)
                .data(teamCreateWeb)
                .build();
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public Response updateTeam(@PathVariable("id") int id, @RequestBody TeamUpdateDTO teamUpdateWeb) {
        Team team = teamMapperController.TeamUpdateDTOtoTeam(teamUpdateWeb);
        teamService.updateTeam(id, team);
        TeamDetailDTO teamWeb = teamMapperController.toTeamDetailDTO(team);
        return Response.builder()
                .data(teamWeb)
                .data(teamUpdateWeb)
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
