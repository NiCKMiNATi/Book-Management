package com.example.task_manager.service;

import com.example.task_manager.model.Team;
import com.example.task_manager.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepo;

    public List<Team> getAllTeams(){
        return teamRepo.findAll();
    }

    public Team getTeamById(Long id){
        return teamRepo.findById(id).orElseThrow(() -> new RuntimeException("Team not found"));
    }

    public Team saveTeam(Team team){
        return teamRepo.save(team);
    }

    public void deleteTeam(Long id){
        teamRepo.deleteById(id);
    }
}
