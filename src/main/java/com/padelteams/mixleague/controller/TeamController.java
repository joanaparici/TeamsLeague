package com.padelteams.mixleague.controller;

import com.padelteams.mixleague.controller.model.team.TeamCreateDTO;
import com.padelteams.mixleague.controller.model.team.TeamDetailDTO;
import com.padelteams.mixleague.controller.model.team.TeamListDTO;
import com.padelteams.mixleague.controller.model.team.TeamUpdateDTO;
import com.padelteams.mixleague.domain.entity.Team;
import com.padelteams.mixleague.domain.service.TeamService;
import com.padelteams.mixleague.http_response.Response;
import com.padelteams.mixleague.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(TeamController.TEAMS)
@RestController
public class TeamController {

    public static final String TEAMS = "teams";

    @Autowired
    private TeamService teamService;
    @Autowired
    private TeamMapper teamMapper;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Response getAll() {
        List<Team> teams = teamService.getAll();
        List<TeamListDTO> teamDTO = teams.stream()
                .map(teamMapper.mapper::toTeamListDTO)
                .toList();
        Response response = Response.builder()
                .data(teamDTO)
                .build();
        return response;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Response getTeam(@PathVariable("id") int id) {
        Optional<Team> team = teamService.findById(id);
        TeamDetailDTO teamWeb = teamMapper.mapper.toTeamDetailDTO(team.orElse(null));
        Response response = Response.builder()
                .data(teamWeb)
                .build();
        return response;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Response addTeam(@RequestBody TeamCreateDTO teamCreateWeb) {
        Team team = teamMapper.mapper.TeamCreateDTOtoTeam(teamCreateWeb);

        teamService.addTeam(team);

        TeamDetailDTO teamWeb = teamMapper.mapper.toTeamDetailDTO(team);

        Response response = Response.builder()
                .data(teamWeb)
                .data(teamCreateWeb)
                .build();
        return response;
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public Response updateTeam(@PathVariable("id") int id, @RequestBody TeamUpdateDTO teamUpdateWeb) {
        Team team = teamMapper.mapper.TeamUpdateDTOtoTeam(teamUpdateWeb);
        teamService.updateTeam(id, team);
        TeamDetailDTO teamWeb = teamMapper.mapper.toTeamDetailDTO(team);
        Response response = Response.builder()
                .data(teamWeb)
                .data(teamUpdateWeb)
                .build();
        return response;
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public Response deleteTeam(@PathVariable("id") int id) {
        teamService.deleteTeam(id);
        Response response = Response.builder()
                .data("Team eliminado con id: " + id)
                .build();
        return response;
    }
}
