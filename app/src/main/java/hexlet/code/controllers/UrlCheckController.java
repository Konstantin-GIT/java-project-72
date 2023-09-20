package hexlet.code.controllers;

import hexlet.code.model.Url;
import hexlet.code.model.UrlCheck;
import hexlet.code.repository.UrlChecksRepository;
import hexlet.code.repository.UrlsRepository;
import io.javalin.http.Handler;
import kong.unirest.Unirest;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.sql.Timestamp;


public class UrlCheckController {

    public static Handler checkCreate = ctx -> {
        long id = ctx.pathParamAsClass("id", Long.class).getOrDefault(null);

        //
        Url url = UrlsRepository.getUrlById(id);
        var datetime = new Timestamp(System.currentTimeMillis());
        var response = Unirest.get(url.getName()).asString();
        var responseBody = response.getBody().toString();

        Document doc = Jsoup.parse(responseBody);
        int codeStatus = response.getStatus();
        String description = doc.selectFirst("meta[name=description]") == null ? ""
            : doc.selectFirst("meta[name=description]").attr("content");
        String title =  doc.title();
        String h1 =  doc.selectFirst("h1") == null ? "" :  doc.selectFirst("h1").html();
        System.out.println("h1 = " + h1);
        System.out.println("description = " + description);

        UrlCheck urlCheck = new UrlCheck(datetime, codeStatus, description, id, title, h1);
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
