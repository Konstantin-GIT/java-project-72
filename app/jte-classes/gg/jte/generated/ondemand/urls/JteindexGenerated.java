package gg.jte.generated.ondemand.urls;
import hexlet.code.model.Url;
import java.util.List;
public final class JteindexGenerated {
	public static final String JTE_NAME = "urls/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,10,10,25,25,27,27,27,28,28,28,29,29,29,31,31,35,40};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, List<Url> urlsList) {
		jteOutput.writeContent("\n<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n    <meta charset=\"UTF-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n    <title>Список URL</title>\n    ");
		jteOutput.writeContent("\n    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n</head>\n<body>\n<div class=\"container mt-5\">\n    <h1 class=\"display-4\">Список URL</h1>\n    <table class=\"table table-striped\">\n        <thead>\n        <tr>\n            <th>ID</th>\n            <th>Name</th>\n            <th>Created At</th>\n        </tr>\n        </thead>\n        <tbody>\n        ");
		for (Url url : urlsList) {
			jteOutput.writeContent("\n        <tr>\n            <td>");
			jteOutput.setContext("td", null);
			jteOutput.writeUserContent(url.getId());
			jteOutput.writeContent("</td>\n            <td>");
			jteOutput.setContext("td", null);
			jteOutput.writeUserContent(url.getName());
			jteOutput.writeContent("</td>\n            <td>");
			jteOutput.setContext("td", null);
			jteOutput.writeUserContent(url.getCreatedAt().toString());
			jteOutput.writeContent("</td>\n        </tr>\n        ");
		}
		jteOutput.writeContent("\n        </tbody>\n    </table>\n</div>\n");
		jteOutput.writeContent("\n<script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>\n<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\"></script>\n</body>\n</html>\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		List<Url> urlsList = (List<Url>)params.get("urlsList");
		render(jteOutput, jteHtmlInterceptor, urlsList);
	}
}
