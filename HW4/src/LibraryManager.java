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

    // Adds a new book to the library or updates stock if it already exists
    private static void addBook(Scanner scanner) throws IOException {
        System.out.print("Enter book title: ");
        String inputTitle = scanner.nextLine().trim();

        System.out.print("Enter author name: ");
        String inputAuthor = scanner.nextLine().trim();

        System.out.print("Enter stock count: ");
        int stock = scanner.nextInt();
        scanner.nextLine(); // consume newline

        boolean bookExists = false;

        for (Book book : books) {
            if (book.getTitle().trim().equalsIgnoreCase(inputTitle) &&
                    book.getAuthor().trim().equalsIgnoreCase(inputAuthor)) {

                // Book already exists, update stock
                book.setStock(book.getStock() + stock);
                FileHandler.saveBooks(books);
                FileHandler.log("Updated stock for existing book: " + inputTitle);
                System.out.println("Book already exists. Stock updated.");
                bookExists = true;
                break;
            }
        }

        if (!bookExists) {
            // New book entry
            books.add(new Book(inputTitle, inputAuthor, stock));
            FileHandler.saveBooks(books);
            FileHandler.log("Added new book: " + inputTitle);
            System.out.println("New book added successfully.");
        }

        displayBooks(); // Show updated list
    }


    // Removes a book from the library
    private static void removeBook(Scanner scanner) throws IOException {
        System.out.print("Enter book title to remove: ");
        String inputTitle = scanner.nextLine().trim();

        System.out.print("Enter author name: ");
        String inputAuthor = scanner.nextLine().trim();

        boolean removed = false;

        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getTitle().trim().equalsIgnoreCase(inputTitle) &&
                    book.getAuthor().trim().equalsIgnoreCase(inputAuthor)) {

                books.remove(i);
                FileHandler.saveBooks(books);
                FileHandler.log("Removed book: " + inputTitle);
                System.out.println("Book removed successfully.");
                removed = true;
                break;
            }
        }

        if (!removed) {
            System.out.println("Book not found. Please check the title and author.");
            FileHandler.log("Attempted to remove non-existent book: " + inputTitle);
        }

        displayBooks(); // Show updated list
    }



    // Updates the stock of an existing book
    private static void updateStock(Scanner scanner) throws IOException, InvalidStockException {
        System.out.print("Enter book title to update: ");
        String inputTitle = scanner.nextLine().trim();

        System.out.print("Enter author name: ");
        String inputAuthor = scanner.nextLine().trim();

        System.out.print("Enter new stock count: ");
        int newStock = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (newStock < 0) {
            throw new InvalidStockException("Stock cannot be negative.");
        }

        boolean found = false;

        for (Book book : books) {
            if (book.getTitle().trim().equalsIgnoreCase(inputTitle) &&
                    book.getAuthor().trim().equalsIgnoreCase(inputAuthor)) {

                book.setStock(newStock);
                FileHandler.saveBooks(books);
                FileHandler.log("Updated stock for: " + inputTitle + " to " + newStock);
                System.out.println("Stock updated successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Book not found. Please check the title and author.");
            FileHandler.log("Attempted to update stock for non-existent book: " + inputTitle);
        }

        displayBooks(); // Show updated list
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
