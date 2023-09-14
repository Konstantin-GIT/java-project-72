package hexlet.code.repository;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * Represents the base repository class.
 */
public class BaseRepository {
    private static final String JDBC_URL = "jdbc:h2:mem:hikariDB";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(JDBC_URL);
        config.setUsername(USERNAME);
        config.setPassword(PASSWORD);
        dataSource = new HikariDataSource(config);
    }

    /**
     * Get the data source.
     *
     * @return The Hikari data source.
     */
    public static HikariDataSource getDataSource() {
        return dataSource;
    }
}
