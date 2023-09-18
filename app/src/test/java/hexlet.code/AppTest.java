package hexlet.code;

import hexlet.code.model.Url;
import hexlet.code.repository.UrlsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import io.javalin.Javalin;
import io.javalin.testtools.JavalinTest;
import static org.assertj.core.api.Assertions.assertThat;

class AppTest {

    // BEGIN
    Javalin app;

    @BeforeEach
    public final void setUp() {
        UrlsRepository.truncateUrls();
        app = App.getApp();

    }

    @Test
    public void testMainPage() {
        JavalinTest.test(app, (server, client) -> {
            var response = client.get("/");
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string()).contains("Анализатор страниц");
        });
    }

    @Test
    public void testCreateUrl() {
        JavalinTest.test(app, (server, client) -> {
            var requestBody = "url=https://javalinTest.io";
            var response = client.post("/urls", requestBody);
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string()).contains("https://javalinTest.io");

        });
    }

    @Test
    public void testShowUrlById() throws SQLException {
        var url = new Url();
        url.setName("https://javalinTest.io");
        UrlsRepository.save(url);

        JavalinTest.test(app, (server, client) -> {
            var response = client.get("/urls/" + url.getId());
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string()).contains("https://javalinTest.io");
        });
    }

    @Test
    public void testNotFoundUrlById() {
        JavalinTest.test(app, (server, client) -> {
            var response = client.get("/urls/777");
            assertThat(response.code()).isEqualTo(404);
        });
    }

    @Test
    public void testNotCorrectUrl() {
        JavalinTest.test(app, (server, client) -> {
            var requestBody = "url=notCorrectUrl";
            var response = client.post("/urls", requestBody);
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string()).contains("Анализатор страниц");
        });
    }

    @Test
    public void testUniqUrlValidation() throws SQLException {
        var url = new Url();
        url.setName("https://javalinTest.io");
        UrlsRepository.save(url);

        JavalinTest.test(app, (server, client) -> {
            var requestBody = "url=https://javalinTest.io";
            var response = client.post("/urls", requestBody);
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string()).contains("Анализатор страниц");
        });
    }

    @Test
    public void testNullUrlValidation() throws SQLException {

        JavalinTest.test(app, (server, client) -> {
            var response = client.post("/urls", "");
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string()).contains("Анализатор страниц");
        });
    }

}
