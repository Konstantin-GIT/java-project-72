package hexlet.code;

import hexlet.code.model.Url;
import hexlet.code.repository.UrlsRepository;
import io.javalin.Javalin;

import java.sql.SQLException;

public class App {

    private static int getPort() {
        String port = System.getenv().getOrDefault("PORT", "7070");
        return Integer.valueOf(port);
    }
    public static Javalin getApp() {
        // Создаём приложение
        Javalin app = Javalin.create(config -> {
            // Включаем логгирование
            config.plugins.enableDevLogging();
        });

        // Добавляем маршруты в приложение
        app.get("/", ctx -> ctx.result("Hello World"));

        // Обработчик before запускается перед каждым запросом
        // Устанавливаем атрибут ctx для запросов
        app.before(ctx -> {
            ctx.attribute("ctx", ctx);
        });

        return app;
    }

    public static void main(String[] args) throws SQLException {
        Javalin app = getApp();
        app.start(getPort());
        UrlsRepository.save(new Url());
    }
}
