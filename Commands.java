package edu.kit.informatik;

import java.util.*;

/**
 * A class with methods to make my code cleaner.
 * 
 * @author Rakan Zeid Al Masri
 * @version 1.0
 */

public class Commands {

    /**
     * Helper method to print error messages when the situation calls for it.
     * @param x An arbitrary integer to call this method inside other methods.
     */

    public static void errorMsg(int x) {
        if (x == 1) {
            Terminal.printLine("OK");
            return;
        } else if (x == 0) {
            Terminal.printError("the name entered is invalid");
            return;
        } else if (x == -1) {
            Terminal.printError("this book doesn't exist");
            return;
        } else if (x == -2) {
            Terminal.printError("this book already exists");
            return;
        } else if (x == -3) {
            Terminal.printError("this contact already exists");
            return;
        }
    }

    /**
     * Method that adds a book to the list of books.
     * @param nameofBook The name of the book we want to add.
     */

    public void addBook(String nameofBook) {
        int ok;
        if (InputValidity.isNameValid(nameofBook)
                && !InputValidity.doesBookExist(ListofBooks.getBookofName(nameofBook))) {
            Book b = new Book(nameofBook);
            ListofBooks.getBooks().add(b);
            ok = 1;
            errorMsg(ok);
            return;
        } else if (!InputValidity.isNameValid(nameofBook)) {
            ok = 0;
            errorMsg(ok);
            return;
        } else {
            ok = -2;
            errorMsg(ok);
            return;
        }
    }

    /**
     * Method to add a person with given information to list of people in an address
     * book.
     * @param nameofBook   The name of the book we want to add said person to.
     * @param nameofPerson The name of said person.
     * @param email        The email of said person.
     * @param phonenum     The phone number of said person.
     */

    public void addPerson(String nameofBook, String nameofPerson, String email, String phonenum) {
        boolean foundContact = false;
        if (InputValidity.isNameValid(nameofBook) && InputValidity.isNameValid(nameofPerson)
                && InputValidity.isEmailValid(email) && InputValidity.isPhoneNumValid(phonenum)
                && InputValidity.doesBookExist(ListofBooks.getBookofName(nameofBook))) {
            for (Person person : ListofBooks.getBookofName(nameofBook).getPeople()) {
                if (person.getNameofPerson().equals(nameofPerson)) {
                    foundContact = true;
                }
            }
            if (foundContact) {
                errorMsg(-3);
                return;
            } else {
                Person p = new Person(nameofPerson, email, phonenum);
                ListofBooks.getBookofName(nameofBook).addPerson(p);
                Terminal.printLine(idString(p.getId()));
                return;
            }
        } else if (!InputValidity.isEmailValid(email)) {
            Terminal.printError("email entered is not valid.");
        } else if (!InputValidity.isNameValid(nameofPerson)) {
            Terminal.printError("the name of the contact entered is not valid");
        } else if (!InputValidity.isPhoneNumValid(phonenum)) {
            Terminal.printError("the phone number entered is not valid");
        }
        return;
    }

    /**
     * Method to remove a book and delete all its contacts from the list of books.
     * @param nameofBook The name of the book we want to remove.
     */

    public void removeBook(String nameofBook) {
        int ok;
        if (InputValidity.doesBookExist(ListofBooks.getBookofName(nameofBook))) {
            Book b = ListofBooks.getBookofName(nameofBook);
            ListofBooks.getBooks().remove(b);
            ok = 1;
        } else {
            ok = -1;
        }
        errorMsg(ok);
        return;
    }

    /**
     * Method to remove a contact from an address book.
     * @param nameofBook The name of the book that contains said contact.
     * @param id The id of the contact to be removed.
     */

    public void removePerson(String nameofBook, int id) {
        int ok;
        boolean foundContact = false;
        Person p = null;
        for (Person person : ListofBooks.getBookofName(nameofBook).getPeople()) {
            if (person.getId() == id) {
                p = person;
                foundContact = true;
            }
        }
        if (p != null) {
            ListofBooks.getBookofName(nameofBook).getPeople().remove(p);
        }
        if (foundContact) {
            ok = 1;

        } else {
            ok = -1;
        }
        errorMsg(ok);
        return;
    }

    /**
     * Method to return id as a String in the required format.
     * @param id The id to be turned into a String.
     * @return Returns id as a String in the format of the question.
     */

    public static String idString(int id) {
        if (id < 10) {
            return "000" + String.valueOf(id);
        } else if (id < 100) {
            return "00" + String.valueOf(id);
        } else if (id < 1000) {
            return "0" + String.valueOf(id);
        } else {
            return String.valueOf(id);
        }
    }

    /**
     * Method to print contacts from an address book in ascending order of indexes.
     * @param nameofBook The name of address book that I want to print.
     */

    public void print(String nameofBook) {
        if (InputValidity.doesBookExist(ListofBooks.getBookofName(nameofBook))) {
            Book p = ListofBooks.getBookofName(nameofBook);
            Collections.sort(p.getPeople());
            for (int i = 0; i < p.bookSize(); i++) {

                /**
                 * Printing the person at a certain index as a String
                 */

                Terminal.printLine(p.getPersonAtIndex(i).toString());
            }
        }
    }

    /**
     * Method to quit program.
     */

    public static void quit() {
        return;
    }
}
