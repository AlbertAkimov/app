package bertos.net.shop.config;

import bertos.net.shop.listeners.AuditorAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @Authot: Albert Akimov
 * @Date: 08.01.2021
 * @Description:
 */

@Configuration
@EnableJpaAuditing(auditorAwareRef = "customAuditProvider")
public class JpaConfiguration {

    @Bean
    public AuditorAware<String> auditorAware(){
        return new AuditorAwareImpl();
    }
}
