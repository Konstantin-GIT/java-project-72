package gg.jte.generated.ondemand;
public final class JteWelcomeGenerated {
	public static final String JTE_NAME = "Welcome.jte";
	public static final int[] JTE_LINE_INFO = {2,2,2,2,28,28,28,28,42,43};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String title) {
		jteOutput.writeContent("\n<!DOCTYPE html>\n<html>\n<head>\n    <meta charset=\"UTF-8\">\n    <title>Company</title>\n    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\"\n          rel=\"stylesheet\"\n          integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\"\n          crossorigin=\"anonymous\">\n</head>\n<body>\n<table class=\"table\">\n    <thead>\n    <tr>\n        <th scope=\"col\">ID</th>\n        <th scope=\"col\">FirstName</th>\n        <th scope=\"col\">LastName</th>\n        <th scope=\"col\">Email</th>\n        <th scope=\"col\"></th>\n    </tr>\n    </thead>\n    <tbody>\n    <tr>\n        <th scope=\"row\">\n            ");
		jteOutput.setContext("th", null);
		jteOutput.writeUserContent(title);
		jteOutput.writeContent("\n        </th>\n        <td>\n        </td>\n\n        <td>\n\n        </td>\n    </tr>\n    </tbody>\n</table>\n\n</body>\n</html>\n");
		jteOutput.writeContent("\n>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String title = (String)params.get("title");
		render(jteOutput, jteHtmlInterceptor, title);
	}
}
