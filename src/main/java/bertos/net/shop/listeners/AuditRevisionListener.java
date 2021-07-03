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

        String currentUser = "";

        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();

        if(authentication.isAuthenticated()) {

            Object principal = authentication.getPrincipal();

            if(principal instanceof String)
                currentUser = (String) principal;
            else
                currentUser = ((User) principal).getUsername();
        }

        AuditRevisionEntity audit = (AuditRevisionEntity) o;
        audit.setUser(currentUser);
    }
}
