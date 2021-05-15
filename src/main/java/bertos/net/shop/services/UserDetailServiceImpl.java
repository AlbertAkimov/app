package bertos.net.shop.services;

import bertos.net.shop.model.Status;
import bertos.net.shop.model.access.User;
import bertos.net.shop.model.access.UserPrivileges;
import bertos.net.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * @Authot: Albert Akimov
 * @Date: 02.05.2020
 * @Description:
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);

        if(user == null)
            throw new UsernameNotFoundException(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        if(user.getBridges() != null) {
            for (UserPrivileges bridge : user.getBridges()) {
                if (bridge.getRole().getStatus() == Status.ACTIVE)
                    grantedAuthorities.add(new SimpleGrantedAuthority(bridge.getRole().getName()));
                if (bridge.getPermission() != null)
                    if (bridge.getPermission().getStatus() == Status.ACTIVE) {
                        grantedAuthorities.add(new SimpleGrantedAuthority(bridge.getPermission().getName()));
                    }
            }
        }
        
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
