package hexlet.code.repository;

import hexlet.code.model.Url;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class UrlsRepository extends BaseRepository {

    public static void save(Url url) throws SQLException {
        var sql = "INSERT INTO urls (name, created_at) VALUES (?, ?)";
        var datetime = new Timestamp(System.currentTimeMillis());
        url.setCreatedAt(datetime);
        try (var conn = BaseRepository.dataSource.getConnection();
            var preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, url.getName());
            preparedStatement.setTimestamp(2, url.getCreatedAt());
            preparedStatement.executeUpdate();
            var generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                url.setId(generatedKeys.getLong(1));
            }
        }
    }

    public static boolean isURLExists(String urlName) throws SQLException {
        var sql = "SELECT * FROM urls WHERE name= ?";
        try (var conn = BaseRepository.dataSource.getConnection();
             var preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, urlName);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return true;
            }
            return false;
        }
    }

    public static Url getUrlById(Long id) throws SQLException {
        var sql = "SELECT * FROM urls WHERE id= ?";
        try (var conn = BaseRepository.dataSource.getConnection();
             var preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                Timestamp createdAt = rs.getTimestamp("created_at");
                Url url = new Url();
                url.setId(id);
                url.setName(name);
                url.setCreatedAt(createdAt);
                return url;
            }
            return null;
        }
    }

    public static List<Url> getUrls() throws SQLException {
        var sql = "SELECT * FROM urls";
        try (var conn = BaseRepository.dataSource.getConnection();
             Statement statement = conn.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            List<Url> urls = new ArrayList<>();
            while (resultSet.next()) {
                // Получить данные из результата запроса

                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Timestamp createdAt = resultSet.getTimestamp("created_at");
                Url url = new Url();
                url.setId(id);
                url.setName(name);
                url.setCreatedAt(createdAt);
                urls.add(url);
                // Обработать полученные данные
            }
            return urls;
        }
    }
    public static void truncateUrls() {

        var sql = "TRUNCATE TABLE urls";

        try (var conn = BaseRepository.dataSource.getConnection();
             var preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
