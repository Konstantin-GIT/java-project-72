package hexlet.code.repository;

import hexlet.code.model.Url;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class UrlsRepository extends BaseRepository {
    public static void save(Url url) throws SQLException {
        var sql1 = "CREATE TABLE Urls (id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255), created_at Timestamp)";

        try (var conn = BaseRepository.getDataSource().getConnection();
             var preparedStatement = conn.prepareStatement(sql1)) {
            preparedStatement.execute();
        }


        var sql = "INSERT INTO urls (name, created_at) VALUES (?, ?)";
        var datetime = new Timestamp(System.currentTimeMillis());
        try (var conn = BaseRepository.getDataSource().getConnection();
            var preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, "1111");
            preparedStatement.setTimestamp(2, datetime);
            preparedStatement.executeUpdate();
            var generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                url.setId(generatedKeys.getLong(1));
                url.setCreatedAt(datetime);
                System.out.println("generatedKeys.getLong(1))!!!!!!!!!!! =  " + generatedKeys.getLong(1));
                System.out.println("JDBC_URL !!!!!!!!!!!!!!! =  " + jdbcUrl);
            } else {
                throw new SQLException("DB have not returned an id after saving an entity");
            }
        }
    }
}
