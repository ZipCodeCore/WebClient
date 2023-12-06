package rocks.zipcode;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class WebClient {
    public static void main(String[] args) throws IOException {
        String url = "http://localhost:8000";
        if (args.length == 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a URL: ");
            url = scanner.nextLine();
        } else {
            url = args[0];
        }
        try {
            URLConnection connection = new URL(url).openConnection();
            InputStream response = connection.getInputStream();
            Scanner webscanner = new Scanner(response);
            String responseBody = webscanner.useDelimiter("\\A").next();
            System.out.println(responseBody);
        } catch (IOException e) {
            System.out.println("Error fetching URL: " + e.getMessage());
        }
    }
}