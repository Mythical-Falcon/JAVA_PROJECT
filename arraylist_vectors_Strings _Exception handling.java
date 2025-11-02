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



import java.util.*;

public class LibraryVectorExample {
    public static void main(String[] args) {

        // Create a vector to store book titles
        Vector<String> books = new Vector<>();

        // ---------- Add Elements ----------
        books.add("Harry Potter");
        books.add("The Hobbit");
        books.add(1, "The Alchemist"); // adds at specific index

        Vector<String> newBooks = new Vector<>();
        newBooks.add("Percy Jackson");
        newBooks.add("Sherlock Holmes");

        // addAll() - adds all elements from another vector
        books.addAll(newBooks);

        System.out.println("Books after adding: " + books);

        // ---------- Access Elements ----------
        System.out.println("\nFirst book: " + books.get(0));

        // Using iterator to access all elements
        System.out.println("\nAll books using Iterator:");
        Iterator<String> itr = books.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        // ---------- Remove Elements ----------
        books.remove(1); // removes element at index 1
        System.out.println("\nAfter removing index 1: " + books);

        // removeAll() - removes all elements
        books.removeAll(newBooks);
        System.out.println("After removeAll(newBooks): " + books);

        // clear() - clears all elements (more efficient)
        books.clear();
        System.out.println("After clear(): " + books);

        // ---------- Capacity ----------
        System.out.println("\nVector capacity: " + books.capacity());
    }
}




public class StringDemo {
    public static void main(String[] args) {

        // ---------------------------
        // PART 1: String Creation
        // ---------------------------

        // Using string literals
        String book1 = "Harry Potter";
        String book2 = "Harry Potter";

        // Using 'new' keyword
        String book3 = new String("Harry Potter");
        String book4 = new String("Harry Potter");

        System.out.println("---- String Creation ----");
        System.out.println("book1 == book2 : " + (book1 == book2));     // true - same reference (SCP)
        System.out.println("book3 == book4 : " + (book3 == book4));     // false - different objects
        System.out.println("book1.equals(book3): " + book1.equals(book3)); // true - same content

        // ---------------------------
        // PART 2: String Class Methods
        // ---------------------------

        String title = "Harry Potter";
        String author = "J.K. Rowling";

        System.out.println("\n---- String Methods ----");

        // 1. length()
        System.out.println("Length of title: " + title.length());

        // 2. charAt()
        System.out.println("Character at index 0: " + title.charAt(0));

        // 3. concat()
        String fullInfo = title.concat(" by ").concat(author);
        System.out.println("Concatenated String: " + fullInfo);

        // 4. toUpperCase() and toLowerCase()
        System.out.println("Uppercase: " + title.toUpperCase());
        System.out.println("Lowercase: " + title.toLowerCase());

        // 5. substring()
        System.out.println("Substring from index 6: " + title.substring(6));
        System.out.println("Substring (0,5): " + title.substring(0, 5));

        // 6. replace()
        System.out.println("Replace 'Harry' with 'Henry': " + title.replace("Harry", "Henry"));

        // 7. contains()
        System.out.println("Contains 'Potter'? " + title.contains("Potter"));

        // 8. equals() and equalsIgnoreCase()
        System.out.println("Equals 'harry potter'? " + title.equals("harry potter"));
        System.out.println("EqualsIgnoreCase 'harry potter'? " + title.equalsIgnoreCase("harry potter"));

        // 9. trim()
        String name = "   The Alchemist   ";
        System.out.println("Trimmed: '" + name.trim() + "'");

        // 10. indexOf()
        System.out.println("Index of 'P': " + title.indexOf('P'));
    }
}



class LibraryStringBufferDemo {
    public static void main(String[] args) {
        // Creating a StringBuffer for book information
        StringBuffer bookInfo = new StringBuffer("Library Management");

        // append() – adding more details
        bookInfo.append(" System");
        System.out.println("After append: " + bookInfo);

        // insert() – inserting text at a specific position
        bookInfo.insert(8, " Digital");
        System.out.println("After insert: " + bookInfo);

        // replace() – replacing a part of the text
        bookInfo.replace(0, 8, "College");
        System.out.println("After replace: " + bookInfo);

        // delete() – removing a range of characters
        bookInfo.delete(0, 7);
        System.out.println("After delete: " + bookInfo);

        // deleteCharAt() – deleting a single character
        bookInfo.deleteCharAt(5);
        System.out.println("After deleteCharAt: " + bookInfo);

        // reverse() – reversing the string
        bookInfo.reverse();
        System.out.println("After reverse: " + bookInfo);
    }
}



// User-defined Exception
class BookNotFoundException extends Exception {
    BookNotFoundException(String message) {
        super(message);
    }
}

public class LibraryExceptionsEasy {
    public static void main(String[] args) {

        // Built-in Exception Example
        try {
            int[] bookIDs = {101, 102, 103};
            System.out.println(bookIDs[5]);  // invalid index
        } 
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Book index not found!");
        }

        // User-defined Exception Example
        try {
            String book = "Python";
            if (!book.equals("Java")) {
                throw new BookNotFoundException(book + " is not available in the library!");
            }
            System.out.println(book + " issued successfully.");
        } 
        catch (BookNotFoundException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        System.out.println("Library system running smoothly...");
    }
}
