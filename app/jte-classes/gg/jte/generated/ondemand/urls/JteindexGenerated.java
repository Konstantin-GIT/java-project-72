package gg.jte.generated.ondemand.urls;
import hexlet.code.model.Url;
import java.util.List;
public final class JteindexGenerated {
	public static final String JTE_NAME = "urls/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,11,11,15,15,17,17,17,19,19,31,31,33,33,33,35,35,35,35,35,35,35,37,37,37,39,39,43,48};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, List<Url> urlsList, String successMessage) {
		jteOutput.writeContent("\n<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n    <meta charset=\"UTF-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n    <title>Список URL</title>\n    ");
		jteOutput.writeContent("\n    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n</head>\n<body>\n");
		if (!successMessage.isEmpty()) {
			jteOutput.writeContent("\n    <div class=\"alert alert-success\" role=\"alert\">\n        ");
			jteOutput.setContext("div", null);
			jteOutput.writeUserContent(successMessage);
			jteOutput.writeContent("\n    </div>\n");
		}
		jteOutput.writeContent("\n<div class=\"container mt-5\">\n    <h1 class=\"display-4\">Список URL</h1>\n    <table class=\"table table-striped\">\n        <thead>\n        <tr>\n            <th>ID</th>\n            <th>Name</th>\n            <th>Created At</th>\n        </tr>\n        </thead>\n        <tbody>\n        ");
		for (Url url : urlsList) {
			jteOutput.writeContent("\n        <tr>\n            <td>");
			jteOutput.setContext("td", null);
			jteOutput.writeUserContent(url.getId());
			jteOutput.writeContent("</td>\n            <td>\n                <a href=\"/urls/");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(url.getId());
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\">");
			jteOutput.setContext("a", null);
			jteOutput.writeUserContent(url.getName());
			jteOutput.writeContent("</a>\n            </td>\n            <td>");
			jteOutput.setContext("td", null);
			jteOutput.writeUserContent(url.getCreatedAt().toString());
			jteOutput.writeContent("</td>\n        </tr>\n        ");
		}
		jteOutput.writeContent("\n        </tbody>\n    </table>\n</div>\n");
		jteOutput.writeContent("\n<script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>\n<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\"></script>\n</body>\n</html>\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		List<Url> urlsList = (List<Url>)params.get("urlsList");
		String successMessage = (String)params.get("successMessage");
		render(jteOutput, jteHtmlInterceptor, urlsList, successMessage);
	}
}
