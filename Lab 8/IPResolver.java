import java.net.*;
import java.util.Scanner;

public class IPResolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            // 1. Display local IP address
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("Your computer's IP address: " + localHost.getHostAddress());

            // 2. Accept domain name
            System.out.print("Enter a domain name (e.g., www.google.com): ");
            String domain = scanner.nextLine();

            // 3. Print all IP addresses of the domain
            InetAddress[] addresses = InetAddress.getAllByName(domain);
            System.out.println("IP addresses for " + domain + ":");
            for (InetAddress addr : addresses) {
                System.out.println("- " + addr.getHostAddress());
            }

        } catch (UnknownHostException e) {
            System.out.println("Error: Unable to resolve host.");
        } finally {
            scanner.close(); // ✅ Properly close the Scanner
        }
    }
}
