import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyMain {
    public static void main(String[] args) {
        PersonList personList = new PersonList();

        try {
            // Read from data.txt file
            File file = new File("data.txt");
            Scanner fileScanner = new Scanner(file);

            // Store persons from file into the list
            personList.store(fileScanner);
            fileScanner.close();

            // Display all persons
            System.out.println("Stored People:");
            personList.display();

            // Find person by ID
            Scanner inputScanner = new Scanner(System.in);
            System.out.println("Enter an ID to search:");
            String idToFind = inputScanner.nextLine();
            int index = personList.find(idToFind);

            if (index != -1) {
                System.out.println("Person found at index " + index + ": " + personList.getPerson(index));
            } else {
                System.out.println("Person not found.");
            }

            inputScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}
