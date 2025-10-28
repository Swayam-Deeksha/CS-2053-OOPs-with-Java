import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HttpHeaderViewer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a URL (e.g., https://www.example.com): ");
        String urlString = scanner.nextLine();

        try {
            // Use URI to avoid deprecated URL constructor
            URI uri = URI.create(urlString);
            URL url = uri.toURL();

            // Open connection and cast to HttpURLConnection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET"); // Default method

            // Connect and retrieve response
            int responseCode = connection.getResponseCode();
            String responseMessage = connection.getResponseMessage();

            // Display request and response info
            System.out.println("\nRequest Method: " + connection.getRequestMethod());
            System.out.println("Response Code: " + responseCode);
            System.out.println("Response Message: " + responseMessage);

            // Display all headers
            System.out.println("\n--- HTTP Headers ---");
            Map<String, List<String>> headers = connection.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                String key = entry.getKey();
                List<String> values = entry.getValue();
                System.out.println((key != null ? key : "Status") + ": " + String.join(", ", values));
            }

        } catch (IOException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
