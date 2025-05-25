import java.io.IOException;
import java.util.*;

public class LibraryManager {
    private static List<Book> books;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            books = FileHandler.loadBooks();
        } catch (IOException e) {
            System.out.println("Error reading books file.");
            FileHandler.log("Failed to load books: " + e.getMessage());
            return;
        }

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Update Stock");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            try {
                switch (option) {
                    case 1:
                        addBook(scanner);
                        break;
                    case 2:
                        removeBook(scanner);
                        break;
                    case 3:
                        updateStock(scanner);
                        break;
                    case 4:
                        FileHandler.saveBooks(books);
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                FileHandler.log("Error: " + e.getMessage());
            }
        }
    }

    // Adds a new book to the list
    private static void addBook(Scanner scanner) throws IOException {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();

        System.out.print("Enter author name: ");
        String author = scanner.nextLine();

        System.out.print("Enter stock count: ");
        int stock = scanner.nextInt();
        scanner.nextLine();

        books.add(new Book(title, author, stock));
        FileHandler.saveBooks(books);
        FileHandler.log("Added book: " + title);
        System.out.println("Book added successfully.");

        displayBooks();  // Show updated list
    }

    // Removes a book by title
    private static void removeBook(Scanner scanner) throws IOException {
        System.out.print("Enter book title to remove: ");
        String title = scanner.nextLine();

        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
        FileHandler.saveBooks(books);
        FileHandler.log("Removed book: " + title);
        System.out.println("Book removed if it existed.");

        displayBooks();  // Show updated list
    }

    // Updates the stock of a book
    private static void updateStock(Scanner scanner) throws IOException, InvalidStockException {
        System.out.print("Enter book title to update: ");
        String title = scanner.nextLine();

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.print("Enter new stock: ");
                int newStock = scanner.nextInt();
                scanner.nextLine();

                if (newStock < 0) {
                    throw new InvalidStockException("Stock cannot be negative.");
                }

                book.setStock(newStock);
                FileHandler.saveBooks(books);
                FileHandler.log("Updated stock for: " + title);
                System.out.println("Stock updated successfully.");
                return;
            }
        }

        System.out.println("Book not found.");

        displayBooks();  // Show updated list
    }

    // Displays all books in the current list
    private static void displayBooks() {
        System.out.println("\n--- Current Book List ---");
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }

        for (Book book : books) {
            System.out.println("Title: " + book.getTitle() +
                    " | Author: " + book.getAuthor() +
                    " | Stock: " + book.getStock());
        }
    }

}
