import java.util.*;

// ---------------------
// User-defined Exception
// ---------------------
class BookNotFoundException extends Exception {
    BookNotFoundException(String message) {
        super(message);
    }
}

// ---------------------
// MAIN CLASS
// ---------------------
public class LibraryManagementApp {
    public static void main(String[] args) {

        // ---------------------------
        // 1️⃣  ARRAYLIST DEMO
        // ---------------------------
        System.out.println("===== ARRAYLIST DEMO =====");
        ArrayList<String> books = new ArrayList<>();
        books.add("Java Basics");
        books.add("Python Crash Course");
        books.add("Clean Code");

        System.out.println("First book: " + books.get(0));

        books.set(1, "C++ Primer");
        System.out.println("After changing second book: " + books);

        books.remove("Clean Code");
        System.out.println("After removal: " + books);



        // ---------------------------
        // 2️⃣  VECTOR DEMO
        // ---------------------------
        System.out.println("\n===== VECTOR DEMO =====");
        Vector<String> library = new Vector<>();
        library.add("Harry Potter");
        library.add("The Hobbit");
        library.add(1, "The Alchemist");

        Vector<String> newBooks = new Vector<>();
        newBooks.add("Percy Jackson");
        newBooks.add("Sherlock Holmes");

        library.addAll(newBooks);
        System.out.println("Books after adding: " + library);

        System.out.println("\nFirst book: " + library.get(0));
        System.out.println("\nAll books using Iterator:");
        Iterator<String> itr = library.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        library.remove(1);
        System.out.println("\nAfter removing index 1: " + library);

        library.removeAll(newBooks);
        System.out.println("After removeAll(newBooks): " + library);

        library.clear();
        System.out.println("After clear(): " + library);
        System.out.println("Vector capacity: " + library.capacity());



        // ---------------------------
        // 3️⃣  STRING DEMO
        // ---------------------------
        System.out.println("\n===== STRING DEMO =====");

        String book1 = "Harry Potter";
        String book2 = "Harry Potter";
        String book3 = new String("Harry Potter");
        String book4 = new String("Harry Potter");

        System.out.println("book1 == book2 : " + (book1 == book2));
        System.out.println("book3 == book4 : " + (book3 == book4));
        System.out.println("book1.equals(book3): " + book1.equals(book3));

        String title = "Harry Potter";
        String author = "J.K. Rowling";
        System.out.println("\nLength: " + title.length());
        System.out.println("charAt(0): " + title.charAt(0));
        System.out.println("concat: " + title.concat(" by ").concat(author));
        System.out.println("toUpperCase: " + title.toUpperCase());
        System.out.println("substring(0,5): " + title.substring(0, 5));
        System.out.println("replace: " + title.replace("Harry", "Henry"));
        System.out.println("contains 'Potter'? " + title.contains("Potter"));
        System.out.println("equalsIgnoreCase: " + title.equalsIgnoreCase("harry potter"));
        String name = "   The Alchemist   ";
        System.out.println("trimmed: '" + name.trim() + "'");
        System.out.println("indexOf('P'): " + title.indexOf('P'));



        // ---------------------------
        // 4️⃣  STRINGBUFFER DEMO
        // ---------------------------
        System.out.println("\n===== STRINGBUFFER DEMO =====");
        StringBuffer info = new StringBuffer("Library Management");
        info.append(" System");
        System.out.println("After append: " + info);
        info.insert(8, " Digital");
        System.out.println("After insert: " + info);
        info.replace(0, 8, "College");
        System.out.println("After replace: " + info);
        info.delete(0, 7);
        System.out.println("After delete: " + info);
        info.deleteCharAt(5);
        System.out.println("After deleteCharAt: " + info);
        info.reverse();
        System.out.println("After reverse: " + info);



        // ---------------------------
        // 5️⃣  EXCEPTION HANDLING
        // ---------------------------
        System.out.println("\n===== EXCEPTION HANDLING DEMO =====");

        // Built-in Exception
        try {
            int[] bookIDs = {101, 102, 103};
            System.out.println(bookIDs[5]); // invalid index
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Book index not found!");
        }

        // User-defined Exception
        try {
            String book = "Python";
            if (!book.equals("Java")) {
                throw new BookNotFoundException(book + " is not available in the library!");
            }
            System.out.println(book + " issued successfully.");
        } catch (BookNotFoundException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        System.out.println("\n✅ Library system running smoothly...");
    }
}
