package hexlet.code.repository;

import hexlet.code.dto.UrlMainReport;
import hexlet.code.model.UrlCheck;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class UrlChecksRepository extends BaseRepository {

    public static Boolean save(UrlCheck urlCheck) throws SQLException {
        var sql = """
            INSERT INTO url_checks (created_at, status_code, description, url_id, title, h1) VALUES (?, ?, ?, ?, ?, ?)
            """;
        var datetime = new Timestamp(System.currentTimeMillis());
        try (var conn = BaseRepository.dataSource.getConnection();
             var preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setTimestamp(1, datetime);
            preparedStatement.setInt(2, urlCheck.getStatusCode());
            preparedStatement.setString(3, urlCheck.getDescription());
            preparedStatement.setLong(4, urlCheck.getUrlId());
            preparedStatement.setString(5, urlCheck.getTitle());
            preparedStatement.setString(6, urlCheck.getH1());

            preparedStatement.executeUpdate();
            var generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                urlCheck.setId(generatedKeys.getLong(1));
                return true;
            }
        }
        return false;
    };

    public static List<UrlCheck> getUrlChecks(long urlId) throws SQLException {
        var sql = "SELECT * FROM url_checks WHERE url_id=? ORDER BY id DESC LIMIT 30";
        try (var conn = BaseRepository.dataSource.getConnection();
             var preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))  {
            preparedStatement.setLong(1, urlId);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<UrlCheck> urlChecks = new ArrayList<>();
            while (resultSet.next()) {
                // Получить данные из результата запроса
                int id = resultSet.getInt("id");
                Timestamp createdAt = resultSet.getTimestamp("created_at");
                int statusCode = resultSet.getInt("status_code");
                String discription = resultSet.getString("description");
                String title = resultSet.getString("title");
                String h1 = resultSet.getString("h1");
                UrlCheck urlCheck = new UrlCheck();
                urlCheck.setId(id);
                urlCheck.setCreatedAt(createdAt);
                urlCheck.setStatusCode(statusCode);
                urlCheck.setDescription(discription);
                urlCheck.setUrlId(urlId);
                urlCheck.setTitle(title);
                urlCheck.setH1(h1);
                urlChecks.add(urlCheck);
                // Обработать полученные данные
            }
            return urlChecks;
        }
    }

    public static List<UrlMainReport> getUrlsMainReport() throws SQLException {
        var sql = """
                    SELECT
                        u.id,
                        u.name,
                        uc.status_code,
                        uc.created_at
                    FROM
                        urls u
                    LEFT JOIN (
                        SELECT
                            uc.url_id,
                            uc.status_code,
                            uc.created_at
                        FROM
                            url_checks uc
                        WHERE
                            (uc.url_id, uc.id) IN (
                                SELECT
                                    url_id,
                                    MAX(id)
                                FROM
                                    url_checks
                                GROUP BY
                                    url_id
                            )
                    ) uc ON u.id = uc.url_id
                    ORDER BY u.id DESC
                    LIMIT 30
                    """;

        try (var conn = BaseRepository.dataSource.getConnection();
             var preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))  {
            ResultSet resultSet = preparedStatement.executeQuery();

            List<UrlMainReport> urlsMainReport = new ArrayList<>();
            while (resultSet.next()) {
                // Получить данные из результата запроса
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int statusCode = resultSet.getInt("status_code");
                Timestamp lastCheck = resultSet.getTimestamp("created_at");

                UrlMainReport urlMainReport = new UrlMainReport();
                urlMainReport.setId(id);
                urlMainReport.setName(name);
                urlMainReport.setStatusCode(statusCode);
                urlMainReport.setLastCheck(lastCheck);
                urlsMainReport.add(urlMainReport);
                // Обработать полученные данные
            }
            return urlsMainReport;
        }
    }


}
