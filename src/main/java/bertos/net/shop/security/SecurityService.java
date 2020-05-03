package bertos.net.shop.security;

/**
 * @Authot: Albert Akimov
 * @Date: 02.05.2020
 * @Description:
 */
public interface SecurityService {

    String findLoggedInUsername();
    void autoLogin(String username, String password);
}
