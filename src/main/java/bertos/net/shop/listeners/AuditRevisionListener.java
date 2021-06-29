package bertos.net.shop.listeners;

import bertos.net.shop.model.audit.AuditRevisionEntity;
import org.hibernate.envers.RevisionListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

/**
 * @Authot: Albert Akimov
 * @Date: 27.06.2021
 * @Description:
 */
public class AuditRevisionListener implements RevisionListener {

    @Override
    public void newRevision(Object o) {

        String currentUser = Optional.ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .filter(Authentication::isAuthenticated)
                .map(Authentication::getPrincipal)
                .map(User.class::cast)
                .map(User::getUsername)
                .orElse("Unknown-User");

        AuditRevisionEntity audit = (AuditRevisionEntity) o;
        audit.setUser(currentUser);
    }
}
