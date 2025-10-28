import java.util.*;

public class PlaylistManager {
    static LinkedList<String> playlist = new LinkedList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.print("""
                \n1. Add Song  2. Remove Song
                3. Replace Song  4. Display Playlist  5. Exit
                Choose: """);
            int choice = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Add at 1.Beginning 2.End: ");
                    int pos = sc.nextInt();
                    sc.nextLine(); // consume leftover newline
                    System.out.print("Song name: ");
                    String song = sc.nextLine();
                    if (pos == 1) playlist.addFirst(song);
                    else playlist.addLast(song);
                }
                case 2 -> {
                    System.out.print("Remove 1.First 2.Last: ");
                    int opt = sc.nextInt();
                    sc.nextLine(); // consume leftover newline
                    if (playlist.isEmpty()) {
                        System.out.println("Playlist is empty.");
                    } else if (opt == 1) {
                        playlist.removeFirst();
                    } else {
                        playlist.removeLast();
                    }
                }
                case 3 -> {
                    System.out.print("Index to replace: ");
                    int idx = sc.nextInt();
                    sc.nextLine(); // consume leftover newline
                    if (idx >= 0 && idx < playlist.size()) {
                        System.out.print("New song name: ");
                        String newSong = sc.nextLine();
                        playlist.set(idx, newSong);
                    } else {
                        System.out.println("Invalid index.");
                    }
                }
                case 4 -> display();
                case 5 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    static void display() {
        System.out.println("\nPlaylist:");
        if (playlist.isEmpty()) {
            System.out.println("No songs in playlist.");
        } else {
            for (int i = 0; i < playlist.size(); i++) {
                System.out.println(i + ": " + playlist.get(i));
            }
        }
    }
}
