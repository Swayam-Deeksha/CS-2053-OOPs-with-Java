import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    private static ArrayList<String> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Student Manager ---");
            System.out.println("1. Add Student");
            System.out.println("2. Insert Student at Index");
            System.out.println("3. Update Student Name");
            System.out.println("4. Remove Student (by name or index)");
            System.out.println("5. Display Students");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> insertStudent();
                case 3 -> updateStudent();
                case 4 -> removeStudent();
                case 5 -> displayStudents();
                case 6 -> System.out.println("Exiting program.");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);
    }

    private static void addStudent() {
        System.out.print("Enter student name to add: ");
        String name = scanner.nextLine();
        students.add(name);
        System.out.println("Student added.");
        displayStudents();
    }

    private static void insertStudent() {
        System.out.print("Enter student name to insert: ");
        String name = scanner.nextLine();
        System.out.print("Enter index to insert at: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // consume newline
        if (index >= 0 && index <= students.size()) {
            students.add(index, name);
            System.out.println("Student inserted.");
        } else {
            System.out.println("Invalid index.");
        }
        displayStudents();
    }

    private static void updateStudent() {
        System.out.print("Enter index of student to update: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // consume newline
        if (index >= 0 && index < students.size()) {
            System.out.print("Enter new name: ");
            String newName = scanner.nextLine();
            students.set(index, newName);
            System.out.println("Student updated.");
        } else {
            System.out.println("Invalid index.");
        }
        displayStudents();
    }

    private static void removeStudent() {
        System.out.println("Remove by:");
        System.out.println("1. Name");
        System.out.println("2. Index");
        System.out.print("Enter choice: ");
        int option = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (option == 1) {
            System.out.print("Enter name to remove: ");
            String name = scanner.nextLine();
            if (students.remove(name)) {
                System.out.println("Student removed.");
            } else {
                System.out.println("Student not found.");
            }
        } else if (option == 2) {
            System.out.print("Enter index to remove: ");
            int index = scanner.nextInt();
            scanner.nextLine(); // consume newline
            if (index >= 0 && index < students.size()) {
                students.remove(index);
                System.out.println("Student removed.");
            } else {
                System.out.println("Invalid index.");
            }
        } else {
            System.out.println("Invalid option.");
        }
        displayStudents();
    }

    private static void displayStudents() {
        System.out.println("\nCurrent Student List:");
        if (students.isEmpty()) {
            System.out.println("No students in the list.");
        } else {
            for (int i = 0; i < students.size(); i++) {
                System.out.println(i + ": " + students.get(i));
            }
        }
    }
}
