package com.umurava.umapis.security;

import com.umurava.umapis.exception.NotFoundException;
import com.umurava.umapis.model.User;
import com.umurava.umapis.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User newUser = this.userService.getUserByEmail(username);
        if (newUser == null) { throw new NotFoundException("User not found!!!"); }
        return new CustomUserDetails(newUser);
    }

}
