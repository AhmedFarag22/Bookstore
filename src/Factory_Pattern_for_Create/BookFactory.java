package Factory_Pattern_for_Create;

import model.Book;
import model.EBook;
import model.PaperBook;
import model.ShowcaseBook;

public class BookFactory {
    public static Book createBook(String type, String isbn, String title, int year, double price, String author, Object extra) {
        switch (type.toLowerCase()) {
            case "paper":
                return new PaperBook(isbn, title, year, price, author, (int) extra);
            case "ebook":
                return new EBook(isbn, title, year, price, author, (String) extra);
            case "showcase":
                return new ShowcaseBook(isbn, title, year, price, author);
            default:
                throw new IllegalArgumentException("Unknown book type: " + type);


        }


    }
}
