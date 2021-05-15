package bertos.net.shop.services;

import bertos.net.shop.model.Sidebar;
import bertos.net.shop.repository.SidebarRepository;
import org.springframework.stereotype.Service;

/**
 * @Authot: Albert Akimov
 * @Date: 15.11.2020
 * @Description:
 */
@Service
public class SidebarService extends AbstractCRUDServiceImpl<Sidebar, SidebarRepository> {

    public SidebarService(SidebarRepository repository) {
        super(repository, Sidebar.class);
    }
}
