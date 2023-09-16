package gg.jte.generated.ondemand;
public final class JteWelcomeGenerated {
	public static final String JTE_NAME = "Welcome.jte";
	public static final int[] JTE_LINE_INFO = {2,2,2,2,9,9,34,40};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String title) {
		jteOutput.writeContent("<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n    <meta charset=\"UTF-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n    <title>Pretty Bootstrap Form</title>\n    ");
		jteOutput.writeContent("\n    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\n</head>\n<body style=\"background-color: #f8f9fa;\">\n<div class=\"container mt-5\">\n    <div class=\"row justify-content-center\">\n        <div class=\"col-md-6\">\n            <div class=\"card\">\n                <div class=\"card-header bg-primary text-white text-center\">\n                    <h2>Simple Form</h2>\n                </div>\n                <div class=\"card-body\">\n                    <form method=\"post\" action=\"/urls\">\n                        <div class=\"form-group\">\n                            <label for=\"inputField\">Ваше имя:</label>\n                            <input type=\"text\"  class=\"form-control\"  name=\"name\" placeholder=\"Ваше имя\">\n                        </div>\n                        <button type=\"submit\" class=\"btn btn-success btn-block\">Submit</button>\n                    </form>\n                </div>\n            </div>\n        </div>\n    </div>\n</div>\n\n");
		jteOutput.writeContent("\n<script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"></script>\n<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js\"></script>\n<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\n</body>\n</html>\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String title = (String)params.get("title");
		render(jteOutput, jteHtmlInterceptor, title);
	}
}
