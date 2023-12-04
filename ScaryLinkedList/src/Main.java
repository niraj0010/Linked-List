import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.init();
        Scanner scanner = new Scanner(System.in);
        System.out.println("SCARY LINKED LIST");
        System.out.println("Enter the file name:");
        String fileName = scanner.next();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/" + fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                list.insertSorted(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
       // list.buildIndex();
        while (true) {
            System.out.println("Enter the respective number:");
            System.out.println("1. Display the whole list");
            System.out.println("2. Request the length of the whole list");
            System.out.println("3. Delete a single name from the list");
            System.out.println("4. Request the length of a section of the list");
            System.out.println("5. Print names starting with");
            System.out.println("6. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    list.showList();
                    break;
                case 2:
                    System.out.println("Length of the list: " + list.listLen());
                    break;
                case 3:
                    System.out.println("Enter the name you wish  to delete:");
                    String nameToDelete = scanner.next();
                    list.remove(nameToDelete);
                    list.buildIndex();
                    break;
                case 4:
                    System.out.println("Enter the letter you wish to  find the length of:");
                    char alphabet = scanner.next().charAt(0);
                    list.lengthSection(alphabet);
                    break;
                case 5:
                   // list.buildIndex();
                    System.out.println("Enter a alphabet to print names starting with:");
                    char startLetter = scanner.next().charAt(0);
                    list.showSection(startLetter);
                    break;
                case 6:
                    System.out.println("It was really Scary.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
