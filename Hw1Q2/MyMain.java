import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class MyMain {

    // Method to store person data in the LinkedList
    public static void store(Scanner input, LinkedList<Person> list) {
        while (input.hasNext()) {
            String firstName = input.next();
            String lastName = input.next();
            String id = input.next();
            list.add(new Person(firstName, lastName, id));
        }
    }

    // Method to display all persons in the LinkedList
    public static void display(LinkedList<Person> list) {
        for (Person person : list) {
            System.out.println(person);
        }
    }

    // Method to find a person by their ID
    public static int find(String id, LinkedList<Person> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                return i; 
            }
        }
        return -1; // Return -1 if not found
    }

    public static void main(String[] args) {
        LinkedList<Person> personList = new LinkedList<>();
        
        try {
            // Read data from a file
            Scanner fileScanner = new Scanner(new File("data.txt")); 
            store(fileScanner, personList);
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Data file not found.");
            return;
        }

        // Display all the people
        System.out.println("Stored People:");
        display(personList);

        // Search for a person by ID
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an ID to search:");
        String idToFind = scanner.nextLine();
        int index = find(idToFind, personList);
        if (index != -1) {
            System.out.println("Person found at index " + index + ": " + personList.get(index));
        } else {
            System.out.println("Person not found.");
        }
        scanner.close();
    }
}

