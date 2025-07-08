package inventory;

import model.Book;
import model.PaperBook;

import java.util.*;

public class Inventory {
    private Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
        System.out.println("Quantum book store: Book added - " + book.getTitle());
    }

    public Book removeBook(String isbn) {
        return books.remove(isbn);
    }

    public List<Book> removeOutdatedBooks(int maxYears) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        List<Book> removed = new ArrayList<>();

        for (Iterator<Map.Entry<String, Book>> it = books.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, Book> entry = it.next();
            if (currentYear - entry.getValue().getYear() > maxYears) {
                removed.add(entry.getValue());
                it.remove();
            }
        }

        return removed;
    }

    public double buyBook(String isbn, int quantity, String email, String address) {
       Book book = books.get(isbn);
       if (book == null || !book.isForSale() || !book.isAvailable()) {
           throw new IllegalArgumentException("Quantum book store: Book not available for sale.");
       }

       if (book instanceof PaperBook) {
           ((PaperBook) book).reduceStock(quantity);
       }

       double total = book.getPrice() * quantity;
       book.deliver(email, address);
       return total;
    }

    public void listInventory() {
        for (Book b : books.values()) {
            System.out.println("Quantum book store: Book -> " + b.getTitle() + ", " + b.getIsbn());
        }
    }
}
