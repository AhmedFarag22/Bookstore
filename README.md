# 📚 Quantum Bookstore

A clean, extensible Java-based OOP project simulating an online bookstore, applying SOLID principles and design patterns such as **Strategy** and **Factory**.

---

## 🚀 Features

- Add multiple types of books to inventory:
  - `📦 PaperBook`: Has stock and is shipped to an address
  - `📩 EBook`: Sent via email and has a file type (e.g., PDF)
  - `🛑 ShowcaseBook`: Not for sale, demo display only
- Purchase books using ISBN, with quantity, email, and address
- Automatically removes outdated books by publishing year
- Delivery behavior is handled using the **Strategy Design Pattern**
- Book creation uses the **Factory Design Pattern**
- All outputs are prefixed with `Quantum book store` for consistent logging

---

## 🛠️ Tech Stack

- **Language**: Java
- **Design Patterns**:
  - `Strategy Pattern`: for delivery mechanism (Email, Shipping, No Delivery)
  - `Factory Pattern`: for flexible creation of book types
- **OOP Principles**: Abstraction, Encapsulation, Inheritance, Polymorphism

---



## ✅ Usage Example

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



## Output
Quantum book store: Book added - Java in Depth
Quantum book store: Book added - Effective Java
Quantum book store: Book added - Demo Book


Quantum book store: Book -> Java in Depth, ISBN1
Quantum book store: Book -> Demo Book, ISBN3
Quantum book store: Book -> Effective Java, ISBN2

Buying Paper Book:
Quantum book store: Shipping book to Cairo ,Egypt
Quantum book store: Paid = 600.0

Buying EBook:
Quantum book store: Sending eBook to test@email.com
Quantum book store: Paid = 200.0

Removing outdated books older than 10 years:
Quantum book store: Removed - Demo Book




![Capture2](https://github.com/user-attachments/assets/1ce51040-c8ab-44b9-bf0f-3350bee96166)
