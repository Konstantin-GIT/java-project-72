package hexlet.code.controllers;

import io.javalin.http.Handler;
import java.util.Map;

public class RootController {

    public static Handler index = ctx -> {
        System.out.println(" index !!!!!!");
        var errorMessage = ctx.consumeSessionAttribute("errorMessage");
        errorMessage =  errorMessage == null ? "" : errorMessage;
        ctx.render("index.jte", Map.of("errorMessage", errorMessage));

    };
}
