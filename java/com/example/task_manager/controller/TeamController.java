package com.example.task_manager.controller;

import com.example.task_manager.model.Team;
import com.example.task_manager.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping
    public String getAllTeams(Model model){
        model.addAttribute("teams", teamService.getAllTeams());
        return "teams/list";
    }

    @GetMapping("/new")
    public String addTeam(Model model){
        model.addAttribute("team", new Team());
        return "teams/add";
    }

    @PostMapping("/new")
    public String createTeam(@ModelAttribute("team") Team team){
        teamService.saveTeam(team);
        return "redirect:/teams";
    }

    @GetMapping("/edit/{id}")
    public String editTeam(@PathVariable("id") Long id, Model model){
        model.addAttribute("team", teamService.getTeamById(id));
        return "teams/add";
    }

    @PostMapping("/edit")
    public String saveTeam(@ModelAttribute("team")Team team){
        teamService.saveTeam(team);
        return "redirect:/teams";
    }

    @GetMapping("/delete/{id}")
    public String deleteTeam(@PathVariable("id") Long id){
        teamService.deleteTeam(id);
        return "redirect:/teams";
    }
}
