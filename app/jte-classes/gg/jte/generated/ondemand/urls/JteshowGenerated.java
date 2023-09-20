package gg.jte.generated.ondemand.urls;
import hexlet.code.model.Url;
import hexlet.code.model.UrlCheck;
import java.util.List;
public final class JteshowGenerated {
	public static final String JTE_NAME = "urls/show.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,3,3,17,17,21,21,23,23,23,25,25,26,26,28,28,28,30,30,35,35,35,36,36,36,37,37,37,40,40,40,40,58,58,60,60,60,61,61,61,62,62,62,63,63,63,64,64,64,65,65,65,67,67,72,77};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Url url, List<UrlCheck> urlChecksList, String successMessage, String errorMessage) {
		jteOutput.writeContent("\n\n\n\n<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n    <meta charset=\"UTF-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n    <title>Информация о URL</title>\n    ");
		jteOutput.writeContent("\n    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n</head>\n<body>\n");
		if (!successMessage.isEmpty()) {
			jteOutput.writeContent("\n    <div class=\"alert alert-success\" role=\"alert\">\n        ");
			jteOutput.setContext("div", null);
			jteOutput.writeUserContent(successMessage);
			jteOutput.writeContent("\n    </div>\n");
		}
		jteOutput.writeContent("\n");
		if (!errorMessage.isEmpty()) {
			jteOutput.writeContent("\n    <div class=\"alert alert-success\" role=\"alert\">\n        ");
			jteOutput.setContext("div", null);
			jteOutput.writeUserContent(errorMessage);
			jteOutput.writeContent("\n    </div>\n");
		}
		jteOutput.writeContent("\n<div class=\"container mt-5\">\n    <h1 class=\"display-4\">Информация о URL</h1>\n    <div class=\"card\">\n        <div class=\"card-body\">\n            <h5 class=\"card-title\">ID ");
		jteOutput.setContext("h5", null);
		jteOutput.writeUserContent(url.getId());
		jteOutput.writeContent("</h5>\n            <p class=\"card-text\">Имя ");
		jteOutput.setContext("p", null);
		jteOutput.writeUserContent(url.getName());
		jteOutput.writeContent("</p>\n            <p class=\"card-text\">Дата создания ");
		jteOutput.setContext("p", null);
		jteOutput.writeUserContent(url.getCreatedAt().toString());
		jteOutput.writeContent("</p>\n        </div>\n    </div>\n    <form method=\"post\" action=\"/urls/");
		jteOutput.setContext("form", "action");
		jteOutput.writeUserContent(url.getId());
		jteOutput.setContext("form", null);
		jteOutput.writeContent("/checks\">\n        <div class=\"form-group\">\n            <label for=\"inputField\">Проверки</label>\n        </div>\n        <button type=\"submit\" class=\"btn btn-success btn-block\">Запустить проверку</button>\n    </form>\n    <table class=\"table table-striped\">\n        <thead>\n        <tr>\n            <th>ID</th>\n            <th>Код ответа</th>\n            <th>title</th>\n            <th>h1</th>\n            <th>description</th>\n            <th>Дата проверки</th>\n        </tr>\n        </thead>\n        <tbody>\n        ");
		for (UrlCheck urlCheck : urlChecksList) {
			jteOutput.writeContent("\n            <tr>\n                <td>");
			jteOutput.setContext("td", null);
			jteOutput.writeUserContent(urlCheck.getId());
			jteOutput.writeContent("</td>\n                <td>");
			jteOutput.setContext("td", null);
			jteOutput.writeUserContent(urlCheck.getStatusCode());
			jteOutput.writeContent("</td>\n                <td>");
			jteOutput.setContext("td", null);
			jteOutput.writeUserContent(urlCheck.getTitle());
			jteOutput.writeContent("</td>\n                <td>");
			jteOutput.setContext("td", null);
			jteOutput.writeUserContent(urlCheck.getH1());
			jteOutput.writeContent("</td>\n                <td>");
			jteOutput.setContext("td", null);
			jteOutput.writeUserContent(urlCheck.getDescription());
			jteOutput.writeContent("</td>\n                <td>");
			jteOutput.setContext("td", null);
			jteOutput.writeUserContent(urlCheck.getCreatedAt().toString());
			jteOutput.writeContent("</td>\n            </tr>\n        ");
		}
		jteOutput.writeContent("\n        </tbody>\n    </table>\n</div>\n\n");
		jteOutput.writeContent("\n<script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>\n<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\"></script>\n</body>\n</html>\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Url url = (Url)params.get("url");
		List<UrlCheck> urlChecksList = (List<UrlCheck>)params.get("urlChecksList");
		String successMessage = (String)params.get("successMessage");
		String errorMessage = (String)params.get("errorMessage");
		render(jteOutput, jteHtmlInterceptor, url, urlChecksList, successMessage, errorMessage);
	}
}
