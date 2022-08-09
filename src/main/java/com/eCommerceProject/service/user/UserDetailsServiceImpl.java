package com.eCommerceProject.service.user;

import com.eCommerceProject.model.User;
import com.eCommerceProject.security.JwtUserDetails;
import com.eCommerceProject.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getByUserName(username);
        return JwtUserDetails.create(user);
    }

    public UserDetails loadUserById(int id) {
        User user = userService.getById(id);
        return JwtUserDetails.create(user);
    }

}
