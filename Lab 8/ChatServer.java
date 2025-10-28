import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Server is running. Waiting for client...");
            try (Socket clientSocket = serverSocket.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                System.out.println("Client connected.");
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Client says: " + message);
                }
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}

/* - Run ChatServer first — it will wait for a connection.
- Then run ChatClient — type messages and see them appear on the server.
- Type exit in the client to disconnect.
 */
