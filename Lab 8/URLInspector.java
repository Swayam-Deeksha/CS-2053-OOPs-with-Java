import java.io.*;
import java.net.*;
import java.util.*;

public class URLInspector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a URL (e.g., https://www.example.com): ");
        String urlString = scanner.nextLine();

        try {
            // Use URI to avoid deprecated URL constructor
            URI uri = URI.create(urlString);
            URL url = uri.toURL();
            URLConnection connection = url.openConnection();

            // 1. Protocol
            System.out.println("Protocol: " + url.getProtocol());

            // 2. Content Type
            String contentType = connection.getContentType();
            System.out.println("Content Type: " + (contentType != null ? contentType : "Not available"));

            // 3. Date Info
            long date = connection.getDate();
            System.out.println("Date: " + (date != 0 ? new Date(date) : "Not available"));

            // 4. Content Length
            int length = connection.getContentLength();
            System.out.println("Content Length: " + (length != -1 ? length + " bytes" : "Not available"));

            // 5. First few lines of webpage content
            System.out.println("\n--- Webpage Content Preview ---");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                for (int i = 0; i < 5; i++) {
                    String line = reader.readLine();
                    if (line == null) break;
                    System.out.println(line);
                }
            }

        } catch (IllegalArgumentException | MalformedURLException e) {
            System.out.println("Invalid URL format.");
        } catch (IOException e) {
            System.out.println("Error accessing the URL: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
