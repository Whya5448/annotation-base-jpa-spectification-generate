package org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate;

import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    public DataSource dataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl("jdbc:h2:mem:default;MODE=Oracle;DB_CLOSE_DELAY=-1");
        hikariDataSource.setDriverClassName("org.h2.Driver");
        hikariDataSource.setUsername("sa");
        hikariDataSource.setPassword("");
        return hikariDataSource;
    }

}
