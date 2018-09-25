package com.codeup.investible.Services;

import com.codeup.investible.Models.User;
import com.codeup.investible.Models.UserWithRoles;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service("userSvc")
public class UserService {

    public boolean isLoggedIn() {
        boolean isAnoymousUser =
                SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken;
        return !isAnoymousUser;
    }

    public User loggedInUser() {
        if(!isLoggedIn()) {
            return null;
        }
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public boolean userLoggedInMatchesOwner(User user) {
        return isLoggedIn() && (loggedInUser().getId() == user.getId());
    }

    // Automatically logs in User:
    public void authenticate(User user) {
        // I'm not using roles so I'm using an empty list for the roles
        UserDetails userDetails = new UserWithRoles(user, Collections.emptyList());
        Authentication auth = new UsernamePasswordAuthenticationToken(
                userDetails,
                userDetails.getPassword(),
                userDetails.getAuthorities()
        );
        SecurityContext context = SecurityContextHolder.getContext();
        context.setAuthentication(auth);
    }

    public void deleteSession() {
        SecurityContextHolder.getContext().setAuthentication(null);
    }
}
