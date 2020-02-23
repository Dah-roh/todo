package com.assignment.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.nio.file.attribute.UserPrincipal;

public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repositoryObject;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = repositoryObject.findByUsername();
        if(user == null){
            throw new UsernameNotFoundException("This user was not found");
        }
        return UserPrincipal(user);
    }
}
