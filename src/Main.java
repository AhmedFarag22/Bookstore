import Factory_Pattern_for_Create.BookFactory;

import inventory.Inventory;
import model.Book;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        try {
            Inventory inventory = new Inventory();

            Book book1 = BookFactory.createBook("paper", "ISBN1", "Java in Depth", 2015, 300.0, "John Smith", 10);
            Book book2 = BookFactory.createBook("ebook", "ISBN2", "Effective Java", 2020, 200.0, "Joshua Bloch", "PDF");
            Book book3 = BookFactory.createBook("showcase", "ISBN3", "Demo Book", 2010, 0.0, "Alice", null);

            inventory.addBook(book1);
            inventory.addBook(book2);
            inventory.addBook(book3);

            System.out.println("\n");

            inventory.listInventory();

            System.out.println("\nBuying Paper Book:");
            double total = inventory.buyBook("ISBN1", 2, "test@email.com", "Cairo ,Egypt");
            System.out.println("Quantum book store: Paid = " + total);

            System.out.println("\nBuying EBook:");
            double total2 = inventory.buyBook("ISBN2", 1, "test@email.com", null);
            System.out.println("Quantum book store: Paid = " + total2);

            System.out.println("\nRemoving outdated books older than 10 years:");
            List<Book> removed = inventory.removeOutdatedBooks(10);
            for (Book b : removed) {
                System.out.println("Quantum book store: Removed - " + b.getTitle());
            }
        } catch (Exception e) {
            System.out.println("Quantum book store: Error - " + e.getMessage());
        }

    }
}