package xyz.sadiulhakim.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import xyz.sadiulhakim.user.User;
import xyz.sadiulhakim.user.UserService;

@Service
class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByEmail(username);
        if (user == null) {
            return null;
        }

        return new CustomUserDetails(user.getEmail(), user.getName(),
                user.getPassword(), user.getRole().getName(), user.getPicture());
    }
}
