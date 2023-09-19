package hexlet.code.controllers;

import hexlet.code.model.Url;
import hexlet.code.model.UrlCheck;
import hexlet.code.repository.UrlChecksRepository;
import hexlet.code.repository.UrlsRepository;
import io.javalin.http.Handler;
import kong.unirest.Unirest;

import java.sql.Timestamp;

public class UrlCheckController {

    public static Handler checkCreate = ctx -> {
        long id = ctx.pathParamAsClass("id", Long.class).getOrDefault(null);

        //
        Url url = UrlsRepository.getUrlById(id);
        var datetime = new Timestamp(System.currentTimeMillis());
        var response = Unirest.get(url.getName())
            .asString();
        UrlCheck urlCheck = new UrlCheck(datetime, response.getStatus(), response.getBody(), id);
        Boolean isCheckCreated = UrlChecksRepository.save(urlCheck);

        if (isCheckCreated) {
            ctx.sessionAttribute("successMessage", "Страница успешно проверена");
            ctx.redirect("/urls/" + id);
            return;
        } else {
            ctx.sessionAttribute("errorMessage", "Страница не проверена");
            ctx.redirect("/urls/" + id);
            return;
        }

    };

}
