package com.example.task_manager.service;

import com.example.task_manager.model.Member;
import com.example.task_manager.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepo;

    public List<Member> getAllMembers(){
        return memberRepo.findAll();
    }

    public Member getMemberById(Long id){
        return memberRepo.findById(id).orElseThrow(() -> new RuntimeException("Member not found"));
    }

    public Member saveMember(Member member){
        return memberRepo.save(member);
    }

    public void deleteMember(Long id){
        memberRepo.deleteById(id);
    }

    //This method is added because we are injecting Repository into this, which
    //basically means implementing the Repository interface
    public List<Member> getMembersByTeamId(Long teamId){
        return memberRepo.findByTeamId(teamId);
    }
}
