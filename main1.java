import java.util.*;

// Created class
class Books {
    private int id;
    private String name;
    private String author;

    // Getter and Setter for id
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    // Getter and Setter for name
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    // Getter and Setter for author
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    // Parameterized constructor
    public Books(int id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }
}

// Main function
class Library {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Student info
        System.out.println("Enter your Name: ");
        String studentName = sc.nextLine();

        System.out.println("Enter your ID: ");
        int studentID = sc.nextInt();
        sc.nextLine();
        System.out.println("Name: " + studentName + ", ID: " + studentID);

        // Existing books
        System.out.println("\nId ,Name & Author");
        System.out.println("01 The Alchemist - Paulo Coelho");
        System.out.println("02 To Kill a Mockingbird - Harper Lee");
        System.out.println("03 Harry Potter and the Sorcerer’s Stone - J.K. Rowling");
        System.out.println("04 The Great Gatsby - F. Scott Fitzgerald");
        System.out.println("05 Pride and Prejudice - Jane Austen");

        // Input new book
        System.out.println("\nEnter the Book ID: ");
        int bookID = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the Book Name: ");
        String bookName = sc.nextLine();
        System.out.println("Enter the Author Name: ");
        String authorName = sc.nextLine();

        // Using parameterized constructor to create book object
        Books newBook = new Books(bookID, bookName, authorName);

        // Display book details using getters
        System.out.println("\nBook added successfully!");
        System.out.println("Book ID: " + newBook.getId());
        System.out.println("Book Name: " + newBook.getName());
        System.out.println("Author: " + newBook.getAuthor());
    }
}
