package hexlet.code.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class UrlCheck {

    public UrlCheck() {
    }

    public UrlCheck(Timestamp createdAt, int statusCode, String description, long urlId, String title, String h1) {
        this.createdAt = createdAt;
        this.statusCode = statusCode;
        this.description = description;
        this.urlId = urlId;
        this.title = title;
        this.h1 = h1;
        // Другие поля останутся неинициализированными
    }

    private long id;

    private Timestamp createdAt;

    private int statusCode;

    private String title;

    private String description;

    private long urlId;

    private String h1;


}
