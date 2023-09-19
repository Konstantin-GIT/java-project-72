package hexlet.code;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import gg.jte.resolve.ResourceCodeResolver;
import hexlet.code.controllers.UrlController;
import hexlet.code.controllers.RootController;
import hexlet.code.repository.BaseRepository;
import io.javalin.Javalin;
import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import io.javalin.rendering.template.JavalinJte;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.stream.Collectors;

import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.get;

public class App {

    private static int getPort() {
        String port = System.getenv().getOrDefault("PORT", "7070");
        return Integer.valueOf(port);
    }

    private static final String JDBC_URL_H2 = "jdbc:h2:./hikariDB";

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

    public static Javalin getApp() throws IOException {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(jdbcUrlCurrent);
        var dataSource  = new HikariDataSource(hikariConfig);

        var url = App.class.getClassLoader().getResource("schema.sql");
        var file = new File(url.getFile());
        var sql = Files.lines(file.toPath())
            .collect(Collectors.joining("\n"));

        System.out.println(sql);
        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        BaseRepository.dataSource = dataSource;

        // Создаём приложение
        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });
        JavalinJte.init(createTemplateEngine());

        // Добавляем маршруты в приложение
        addRoutes(app);

        // Обработчик before запускается перед каждым запросом
        // Устанавливаем атрибут ctx для запросов
        app.before(ctx -> {
            ctx.attribute("ctx", ctx);
        });

        return app;
    }


    private static void addRoutes(Javalin app) {
        app.routes(() -> {
            path("/", () -> {
                get(RootController.index);
            });
            path("/urls", () -> {
                post(UrlController.createUrl);
                get(UrlController.getUrls);
                path("{id}/", () -> {
                    get(UrlController.showUrl);
                });
            });
        });

    }


    private static TemplateEngine createTemplateEngine() {
        ClassLoader classLoader = App.class.getClassLoader();
        ResourceCodeResolver codeResolver = new ResourceCodeResolver("templates", classLoader);
        TemplateEngine templateEngine = TemplateEngine.create(codeResolver, ContentType.Html);
        return templateEngine;
    }


    public static void main(String[] args) throws SQLException, IOException {
        Javalin app = getApp();
        app.start(getPort());
    }
}
