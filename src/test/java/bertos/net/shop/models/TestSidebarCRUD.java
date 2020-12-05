package bertos.net.shop.models;

import bertos.net.shop.Application;
import bertos.net.shop.model.Sidebar;
import bertos.net.shop.services.SidebarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Authot: Albert Akimov
 * @Date: 15.11.2020
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@SpringBootConfiguration
@ContextConfiguration
public class TestSidebarCRUD extends AbstractTestCRUD<Sidebar, SidebarService> {

    @Test
    public void testCRUD() {

/*        Sidebar sidebar = new Sidebar();
        sidebar.setValue("Справочники");
        sidebar.setIcon("fas fa-bars");
        sidebar.setSidebarId("references_book");
        sidebar.setIsGroup(false);
        sidebar.setParentId(0L);*/

        Sidebar sidebar = new Sidebar();
        sidebar.setValue("Тип цен");
        sidebar.setIcon("fas fa-bars");
        sidebar.setSidebarId("typePrice");
        sidebar.setIsGroup(false);
        sidebar.setParentId(1L);

        init(sidebar, false);
        run();
    }
}
