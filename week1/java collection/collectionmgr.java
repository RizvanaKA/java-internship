import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class collectionmgr {

    // ArrayList
    ArrayList<String> items = new ArrayList<>();

    public void addItem(String item) {
        items.add(item);
        System.out.println("Item added successfully!");
    }

    public void viewItems() {
        System.out.println("Items: " + items);
    }

    public void updateItem(String oldItem, String newItem) {
        if (items.contains(oldItem)) {
            int index = items.indexOf(oldItem);
            items.set(index, newItem);
            System.out.println("Item updated successfully!");
        } else {
            System.out.println("Item not found!");
        }
    }

    public void removeItem(String item) {
        if (items.remove(item)) {
            System.out.println("Item removed successfully!");
        } else {
            System.out.println("Item not found!");
        }
    }

    public void searchItem(String item) {
        if (items.contains(item)) {
            System.out.println("Item found: " + item);
        } else {
            System.out.println("Item not found!");
        }
    }

    // HashMap
    HashMap<Integer, String> students = new HashMap<>();

    public void addStudent(int id, String name) {
        students.put(id, name);
        System.out.println("Student added successfully!");
    }

    public void viewStudent(int id) {
        if (students.containsKey(id)) {
            System.out.println("Student name: " + students.get(id));
        } else {
            System.out.println("Student not found!");
        }
    }

    public void updateStudent(int id, String name) {
        if (students.containsKey(id)) {
            students.put(id, name);
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    // Queue
    Queue<String> customers = new LinkedList<>();

    public void addCustomer(String name) {
        customers.add(name);
        System.out.println("Customer added successfully!");
    }

    public void removeCustomer() {
        if (customers.isEmpty()) {
            System.out.println("Queue is empty!");
        } else {
            System.out.println("Removed customer: " + customers.remove());
        }
    }

    public void viewQueue() {
        System.out.println("Customer Queue: " + customers);
    }
}