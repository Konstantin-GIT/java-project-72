package gg.jte.generated.ondemand;
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,9,9,13,13,15,15,15,17,17,40,46};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String errorMessage) {
		jteOutput.writeContent("\n<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n    <meta charset=\"UTF-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n    <meta name=\"description\" content=\"Best page analyzer\">\n    <title>Анализатор страниц</title>\n    ");
		jteOutput.writeContent("\n    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\n</head>\n<body style=\"background-color: #f8f9fa;\">\n");
		if (!errorMessage.isEmpty()) {
			jteOutput.writeContent("\n<div class=\"alert alert-danger\" role=\"alert\">\n    ");
			jteOutput.setContext("div", null);
			jteOutput.writeUserContent(errorMessage);
			jteOutput.writeContent("\n</div>\n");
		}
		jteOutput.writeContent("\n\n<div class=\"container mt-5\">\n    <div class=\"row justify-content-center\">\n        <div class=\"col-md-6\">\n            <div class=\"card\">\n                <div class=\"card-header bg-primary text-white text-center\">\n                    <h1>Анализатор страниц</h1>\n                </div>\n                <div class=\"card-body\">\n                    <form method=\"post\" action=\"/urls\">\n                        <div class=\"form-group\">\n                            <label for=\"inputField\">Ссылка:</label>\n                            <input type=\"text\"  class=\"form-control\"  name=\"url\" placeholder=\"Ссылка\">\n                        </div>\n                        <button type=\"submit\" class=\"btn btn-success btn-block\">Submit</button>\n                    </form>\n                </div>\n            </div>\n        </div>\n    </div>\n</div>\n\n");
		jteOutput.writeContent("\n<script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"></script>\n<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js\"></script>\n<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\n</body>\n</html>\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String errorMessage = (String)params.get("errorMessage");
		render(jteOutput, jteHtmlInterceptor, errorMessage);
	}
}
