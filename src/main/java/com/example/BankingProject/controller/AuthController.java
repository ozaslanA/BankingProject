package com.example.BankingProject.controller;

import com.example.BankingProject.dto.RegisterationMember;
import com.example.BankingProject.model.Member;
import com.example.BankingProject.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private AuthenticationService authenticationService;


    @PostMapping("/register")
    public Member register(@RequestBody RegisterationMember registerationMember){
        return authenticationService.register(registerationMember.email(), registerationMember.password());
    }
}
