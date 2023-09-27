package hexlet.code.utils;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlParsing {
    public static String urlParsing(String urlString) throws MalformedURLException {
        URL urlResult;
        // Создаем объект URL, передавая в него строку URL
        URL url = new URL(urlString);
        // Получаем различные компоненты URL
        String protocol = url.getProtocol(); // Протокол (например, "https")
        String host = url.getHost(); // Хост (например, "www.example.com")
        int port = url.getPort(); // Порт (например, 8080, -1 если не указан)
        String path = url.getPath(); // Путь (например, "/path/to/resource")
        String query = url.getQuery(); // Строка запроса (например, "param1=value1&param2=value2")
        String ref = url.getRef(); // Фрагмент (например, "section")

        // Выводим полученные компоненты URL
        System.out.println("Protocol: " + protocol);
        System.out.println("Host: " + host);
        System.out.println("Port: " + port);
        System.out.println("Path: " + path);
        System.out.println("Query: " + query);
        System.out.println("Ref: " + ref);
        urlResult = new URL(protocol, host, port, "");
        return urlResult.toString();

    }
}
