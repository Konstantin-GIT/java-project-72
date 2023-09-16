package hexlet.code;

import gg.jte.resolve.ResourceCodeResolver;
import hexlet.code.controllers.HandlerUrls;
import io.javalin.Javalin;
import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import io.javalin.rendering.template.JavalinJte;
import java.sql.SQLException;
import java.util.Map;

import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;

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
        app.get("/", ctx -> ctx.result("Hello World"));

        app.get("/render", ctx -> ctx.render("Welcome.jte", Map.of("title", "TEST!!!!!!!!")));

        app.routes(() -> {
            path("/urls", () -> {
                post(HandlerUrls.createUrl);
            });
        });

    }


    private static TemplateEngine createTemplateEngine() {
        ClassLoader classLoader = App.class.getClassLoader();
        ResourceCodeResolver codeResolver = new ResourceCodeResolver("templates", classLoader);
        TemplateEngine templateEngine = TemplateEngine.create(codeResolver, ContentType.Html);
        return templateEngine;
    }


    public static void main(String[] args) throws SQLException {
        Javalin app = getApp();
        app.start(getPort());
        //UrlsRepository.save(new Url());
    }
}
