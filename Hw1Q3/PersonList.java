import java.util.LinkedList;
import java.util.Scanner;

public class PersonList {
    private LinkedList<Person> list;

    // Constructor
    public PersonList() {
        this.list = new LinkedList<>();
    }

    // Store persons from the input stream to the linked list
    public void store(Scanner input) {
        while (input.hasNext()) {
            String firstName = input.next();
            String lastName = input.next();
            String id = input.next();
            list.add(new Person(firstName, lastName, id));
        }
    }

    // Display all persons in the linked list
    public void display() {
        for (Person person : list) {
            System.out.println(person);
        }
    }

    // Find a person by ID
    public int find(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    // Get a person by index
    public Person getPerson(int index) {
        if (index >= 0 && index < list.size()) {
            return list.get(index);
        } else {
            return null;
        }
    }
}
