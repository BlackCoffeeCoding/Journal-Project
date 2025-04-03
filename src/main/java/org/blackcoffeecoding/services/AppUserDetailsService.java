package org.blackcoffeecoding.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface AppUserDetailsService{
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
