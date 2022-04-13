package eu._5gzorro.manager.api.config;

import org.springdoc.core.SpringDocUtils;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {

    static {
        SpringDocUtils.getConfig().replaceWithClass(org.threeten.bp.LocalDate.class, java.sql.Date.class);
        SpringDocUtils.getConfig().replaceWithClass(org.threeten.bp.OffsetDateTime.class, java.sql.Date.class);
    }
}
