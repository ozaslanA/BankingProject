package com.example.BankingProject.service;

import com.example.BankingProject.dao.MemberDao;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private MemberDao memberDao;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return memberDao.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Member is not valid"));
    }
}
