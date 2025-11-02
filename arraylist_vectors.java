import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> books = new ArrayList<>();

        // Add
        books.add("Java Basics");
        books.add("Python Crash Course");
        books.add("Clean Code");

        // Access
        System.out.println("First book: " + books.get(0));

        // Change
        books.set(1, "C++ Primer");
        System.out.println("After changing second book: " + books);

        // Remove
        books.remove("Clean Code");
        System.out.println("After removal: " + books);
    }
}
