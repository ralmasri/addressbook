package edu.kit.informatik;

import java.util.*;

/**
 * Class for a list of address books. Static because there is only one such list
 * for the life of the program.
 * 
 * @author Rakan Zeid Al Masri
 * @version 1.0
 */

public class ListofBooks {
    
    /**
     * Static list of all books.
     */
    
    static ArrayList<Book> books = new ArrayList<Book>();

    /**
     * Getter method for the index of a book.
     * 
     * @param b The book we want the index for.
     * @return Returns the index of said book.
     */

    public static int getBookIndex(Book b) {
        return books.indexOf(b);
    }

    /**
     * Getter method for the book given the index of said book.
     * 
     * @param index The index of the book we are looking for.
     * @return Returns the book at that index.
     */

    public static Book getBookatIndex(int index) {
        return books.get(index);
    }

    /**
     * Getter method for the list of books.
     * @return Returns the list of books.
     */
    
    public static ArrayList<Book> getBooks() {
        return books;
    }

    /**
     * Method that iterates through the list of books to return
     * a book given its name
     * @param name The name of the book we want.
     * @return Returns the book we want or null.
     */
    
    public static Book getBookofName(String name) {
        for (Book book : books) {
            if (book.getNameofBook().equals(name)) {
                return book;
            }
        }
        return null;
    }
}
