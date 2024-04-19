package com.example.BankingProject.service;

import com.example.BankingProject.dao.MemberDao;
import com.example.BankingProject.dao.RoleDao;
import com.example.BankingProject.model.Member;
import com.example.BankingProject.model.Role;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthenticationService {

    private MemberDao memberDao;
    private RoleDao roleDao;
    private PasswordEncoder passwordEncoder;


    public Member register(String email,String password){
      Optional<Member> foundMember= memberDao.findByEmail(email);
      if(foundMember.isPresent()){
          throw new RuntimeException("User with given emaily already exist,please login:" + email);
      }
      String encodedPassword=passwordEncoder.encode(password);
     Role userRole= roleDao.findByAuthority("USER").get();
        List<Role> roleList=new ArrayList<>();
        roleList.add(userRole);
        Member member =new Member();
        member.setEmail(email);
        member.setPassword(encodedPassword);
        member.setRoleList(roleList);
        return memberDao.save(member);
    }
}
