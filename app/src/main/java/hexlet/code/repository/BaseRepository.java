package hexlet.code.repository;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * Represents the base repository class.
 */
public class BaseRepository {

    private static int getPort() {
        String port = System.getenv().getOrDefault("PORT", "7070");
        return Integer.valueOf(port);
    }
    private static final String JDBC_URL_H2 = "jdbc:h2:mem:hikariDB";


    static String jdbcUrlCurrent = getJdbcDatabaseUrl();

    public static String getJdbcDatabaseUrl() {
        // Получаем значение переменной окружения JDBC_DATABASE_URL
        String jdbcUrl = System.getenv("JDBC_DATABASE_URL");

        // Если переменная окружения не установлена, устанавливаем значение по умолчанию
        if (jdbcUrl == null || jdbcUrl.isEmpty()) {
            jdbcUrl = JDBC_URL_H2; // Значение по умолчанию
        }

        return jdbcUrl;
    }
    private static HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(jdbcUrlCurrent);
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
