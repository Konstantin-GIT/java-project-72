package hexlet.code.repository;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class BaseRepository {
        public static HikariDataSource dataSource;

        private static final String JDBC_URL = "jdbc:h2:mem:hikariDB";
        private static final String USERNAME = "username";
        private static final String PASSWORD = "password";

        public static HikariDataSource getDataSource() {
                HikariConfig config = new HikariConfig();
                config.setJdbcUrl(JDBC_URL);
                config.setUsername(USERNAME);
                config.setPassword(PASSWORD);
                dataSource = new HikariDataSource(config);
                return dataSource;
        }

}
