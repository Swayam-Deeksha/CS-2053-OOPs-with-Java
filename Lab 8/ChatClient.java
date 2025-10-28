import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Connected to server. Type messages:");
            while (true) {
                String message = scanner.nextLine();
                if (message.equalsIgnoreCase("exit")) break;
                out.println(message);
            }

        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}

/* - Run ChatServer first — it will wait for a connection.
- Then run ChatClient — type messages and see them appear on the server.
- Type exit in the client to disconnect.
 */
