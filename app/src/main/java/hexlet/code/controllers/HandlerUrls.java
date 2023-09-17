package hexlet.code.controllers;

import hexlet.code.repository.UrlsRepository;
import io.javalin.http.Handler;

public class HandlerUrls {

    public static Handler createUrl = ctx -> {
        String url = ctx.formParam("url");
        //ctx.attribute("url", url);
        UrlsRepository.save(url);
        ctx.result("url = " + url + "!");
        //ctx.render("/Welcome.jte");
    };

}
