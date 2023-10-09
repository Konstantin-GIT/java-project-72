package hexlet.code.controllers;

import hexlet.code.model.Url;
import hexlet.code.model.UrlCheck;
import hexlet.code.repository.UrlChecksRepository;
import hexlet.code.repository.UrlsRepository;
import io.javalin.http.Handler;
import io.javalin.http.NotFoundResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

@Slf4j

public class UrlCheckController {

    public static Handler checkUrl = ctx -> {
        long id = ctx.pathParamAsClass("id", Long.class).getOrDefault(null);

        Url url = UrlsRepository.getUrlById(id)
            .orElseThrow(() -> new NotFoundResponse("Url with id = " + id + " not found"));
        try {
            var response = Unirest.get(url.getName()).asString();
            var responseBody = response.getBody().toString();
            Document doc = Jsoup.parse(responseBody);
            int codeStatus = response.getStatus();
            String description = doc.selectFirst("meta[name=description]") == null ? ""
                : doc.selectFirst("meta[name=description]").attr("content");
            String title =  doc.title();
            String h1 =  doc.selectFirst("h1") == null ? "" :  doc.selectFirst("h1").html();
            log.info("h1 = " + h1);
            log.info("description = " + description);
            UrlCheck urlCheck = new UrlCheck(codeStatus, description, id, title, h1);
            UrlChecksRepository.save(urlCheck);
            ctx.sessionAttribute("flash", "Страница успешно проверена");
            ctx.sessionAttribute("flash-type", "success");
        } catch (UnirestException e) {
            ctx.sessionAttribute("flash", "Страница недоступна");
            ctx.sessionAttribute("flash-type", "danger");
        } catch (Exception e) {
            ctx.sessionAttribute("flash", e.getMessage());
            ctx.sessionAttribute("flash-type", "danger");
        }

        ctx.redirect("/urls/" + id);
    };

}
