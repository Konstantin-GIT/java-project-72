package hexlet.code.repository;

import hexlet.code.model.UrlCheck;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class UrlChecksRepository extends BaseRepository {

    public static Boolean save(UrlCheck urlCheck) throws SQLException {
        var sql = "INSERT INTO urlCheck (created_at, status_code, description, url_id) VALUES (?, ?, ?, ?)";

        try (var conn = BaseRepository.dataSource.getConnection();
             var preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setTimestamp(1, urlCheck.getCreatedAt());
            preparedStatement.setInt(2, urlCheck.getStatusCode());
            preparedStatement.setString(3, urlCheck.getDescription());
            preparedStatement.setLong(4, urlCheck.getUrlId());
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
        var sql = "SELECT * FROM urlCheck WHERE url_id=? ORDER BY id DESC LIMIT 30";
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

                UrlCheck urlCheck = new UrlCheck();
                urlCheck.setId(id);
                urlCheck.setCreatedAt(createdAt);
                urlCheck.setStatusCode(statusCode);
                urlCheck.setDescription(discription);
                urlCheck.setUrlId(urlId);
                urlChecks.add(urlCheck);
                // Обработать полученные данные
            }
            return urlChecks;
        }
    }

}
