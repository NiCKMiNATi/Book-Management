package com.example.task_manager.controller;


import com.example.task_manager.model.Member;
import com.example.task_manager.service.MemberService;
import com.example.task_manager.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;
    private final TeamService teamService;

    public MemberController(MemberService memberService, TeamService teamService){
        this.memberService = memberService;
        this.teamService = teamService;
    }

    @GetMapping
    public String getAllMembers(Model model){
        model.addAttribute("members", memberService.getAllMembers());
        return "members/list";
    }

    @GetMapping("/new")
    public String addMember(Model model){
        model.addAttribute("member", new Member());
        model.addAttribute("teams", teamService.getAllTeams());
        return "members/add";
    }

    @PostMapping("/new")
    public String createMember(@ModelAttribute Member member){
        memberService.saveMember(member);
        return "redirect:/members";
    }

    @GetMapping("/edit/{id}")
    public String editMember(@PathVariable("id") Long id, Model model){
        model.addAttribute("member", memberService.getMemberById(id));
        return "members/add";
    }

    @PostMapping("/edit")
    public String saveMember(@ModelAttribute Member member){
        memberService.saveMember(member);
        return "redirect:/members";
    }

    @GetMapping("/delete/{id}")
    public String deleteMemberById(@PathVariable("id")Long id){
        memberService.deleteMember(id);
        return "redirect:/members";
    }
}
