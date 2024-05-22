package app.backend.geo;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.inject.Singleton;
import jakarta.ejb.Startup;

@Singleton
@Startup
@DataSourceDefinition(
        name = "java:global/jdbc/geocodingDS",
        className = "org.h2.jdbcx.JdbcDataSource",
        url = "jdbc:h2:file:~/geocodingDS;DB_CLOSE_ON_EXIT=FALSE",
        user = "sa",
        password = ""
)
public class DatabaseConfig {
}
