package hexlet.code.controllers;

import hexlet.code.model.Url;
import hexlet.code.repository.BaseRepository;
import hexlet.code.repository.UrlsRepository;
import io.javalin.http.Handler;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static hexlet.code.utils.UrlParsing.urlParsing;

public class HandlerUrls {

    public static Handler createUrl = ctx -> {
        String url = ctx.formParam("url");
        String urlResult = urlParsing(url);
        if (urlResult == null) {
            ctx.render("index.jte",  Map.of("errorMessage", "Некорректный URL"));
            return;
        }
        UrlsRepository.save(urlResult);
        ctx.render("index.jte",  Map.of("successMessage", "Страница успешно добавлена"));
    };

    public static Handler getUrls = ctx -> {

        var sql = "SELECT * FROM urls";
        try (var conn = BaseRepository.getDataSource().getConnection();
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
            ctx.render("urls/index.jte", Map.of("urlsList", urls));
        }
    };
}
