// Abstract Class
abstract class Book {
    protected String title;
    protected String author;
    protected String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public abstract void displayDetails(); // Abstract Method
}

// Interface
interface Borrowable {
    void borrowBook(String userId);
    void returnBook(String userId);
}

// Inheritance + Interface Implementation
class PrintedBook extends Book implements Borrowable {
    private boolean isBorrowed;

    public PrintedBook(String title, String author, String isbn) {
        super(title, author, isbn);
        this.isBorrowed = false;
    }

    @Override
    public void displayDetails() {
        System.out.println("Title: " + title + ", Author: " + author + ", ISBN: " + isbn);
    }

    @Override
    public void borrowBook(String userId) {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println(userId + " borrowed " + title);
        } else {
            System.out.println(title + " is already borrowed.");
        }
    }

    @Override
    public void returnBook(String userId) {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println(userId + " returned " + title);
        } else {
            System.out.println(title + " was not borrowed.");
        }
    }
}
