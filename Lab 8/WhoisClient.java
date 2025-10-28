import java.io.*;
import java.net.*;
import java.util.Scanner;

public class WhoisClient {
    public static void main(String[] args) {
        final String WHOIS_SERVER = "whois.internic.net";
        final int WHOIS_PORT = 43;

        try (Scanner scanner = new Scanner(System.in)) {
            // 1. Get domain name from user
            System.out.print("Enter a domain name (e.g., example.com): ");
            String domain = scanner.nextLine();

            // 2. Connect to WHOIS server
            try (Socket socket = new Socket(WHOIS_SERVER, WHOIS_PORT);
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                // 3. Send domain name
                out.println(domain);

                // 4. Read and display WHOIS response
                System.out.println("\nWHOIS Response:");
                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                }

            } catch (IOException e) {
                System.out.println("Error connecting to WHOIS server: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }
}
