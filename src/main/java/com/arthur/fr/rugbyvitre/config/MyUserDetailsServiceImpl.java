package com.arthur.fr.rugbyvitre.config;


import com.arthur.fr.rugbyvitre.model.User;
import com.arthur.fr.rugbyvitre.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserServices userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{
            User user=this.userService.getUserByUsername(username);
            return new MyUserDetails(user);
        }catch (UsernameNotFoundException e){
            throw new UsernameNotFoundException("This username: "+username+"is unknown");
        }
    }
}
