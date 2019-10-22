package onlyTests.networkProgramms.informAboutPage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ConnectionDemo {
    public static void main(String[] args) {
        String urlName = "http://www.elinext.com";
        int timeout = 10_000_000;
        URL url;
        try {
            url = new URL(urlName);
            final URLConnection connection = url.openConnection();
// установка таймаута на соединение
            connection.setConnectTimeout(timeout);
            System.out.println(urlName + " content type: "
                    + connection.getContentType() + "\n" + connection.getHeaderFields());
// продолжение извлечения информации из соединения
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
