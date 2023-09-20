package hexlet.code.controllers;

import hexlet.code.dto.UrlMainReport;
import hexlet.code.model.Url;
import hexlet.code.model.UrlCheck;
import hexlet.code.repository.UrlChecksRepository;
import hexlet.code.repository.UrlsRepository;
import io.javalin.http.Handler;
import java.util.List;
import java.util.Map;
import static hexlet.code.repository.UrlsRepository.getUrlById;
import static hexlet.code.repository.UrlsRepository.isURLExists;
import static hexlet.code.utils.UrlParsing.urlParsing;

public class UrlController {

    public static Handler createUrl = ctx -> {
        String urlFormParam = ctx.formParam("url");
        String urlName = urlParsing(urlFormParam);
        if (urlName == null) {
            ctx.sessionAttribute("errorMessage", "Некорректный URL");
            ctx.redirect("/");
            return;
        } else if (isURLExists(urlName)) {
            ctx.sessionAttribute("errorMessage", "Страница уже существует");
            ctx.redirect("/");
            return;
        }
        Url url = new Url();
        url.setName(urlName);
        UrlsRepository.save(url);
        ctx.sessionAttribute("successMessage", "Страница успешно добавлена");
        ctx.redirect("/urls");
    };

    public static Handler getUrls = ctx -> {
        var successMessage = ctx.consumeSessionAttribute("successMessage");
        successMessage =  successMessage == null ? "" : successMessage;
        List<UrlMainReport> urlsMainReport = UrlChecksRepository.getUrlsMainReport();
        ctx.render("urls/index.jte", Map.of("urlsList", urlsMainReport, "successMessage", successMessage));

    };

    public static Handler showUrl = ctx -> {
        long id = ctx.pathParamAsClass("id", Long.class).getOrDefault(null);
        var successMessage = ctx.consumeSessionAttribute("successMessage");
        var errorMessage = ctx.consumeSessionAttribute("errorMessage");
        successMessage =  successMessage == null ? "" : successMessage;
        errorMessage =  errorMessage == null ? "" : errorMessage;
        Url url = getUrlById(id);
        if (url != null) {
            List<UrlCheck> urlChecks = UrlChecksRepository.getUrlChecks(url.getId());
            ctx.render("urls/show.jte",
                Map.of("url", url, "urlChecksList", urlChecks,
                    "successMessage", successMessage, "errorMessage", errorMessage));
        } else {
            ctx.status(404);
        }

    };

}