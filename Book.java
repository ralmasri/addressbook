package edu.kit.informatik;

import java.util.*;

/**
 * The address book class.
 * 
 * @author Rakan Zeid Al Masri
 * @version 1.0
 */

public class Book {
    
    /**
     * Array list of contacts.
     */
    
    ArrayList<Person> people;
    private String nameofBook;

    /**
     * Constructor for address book.
     * 
     * @param nameofBook The name of said address book.
     * @param people     An array list of type Person.
     */

    public Book(String nameofBook, ArrayList<Person> people) {
        this.nameofBook = nameofBook;
        this.people = people;
    }

    /**
     * Another Constructor for address book.
     * @param nameofBook The name of said address book.
     */

    public Book(String nameofBook) {
        this.nameofBook = nameofBook;
        this.people = new ArrayList<Person>();
    }

    /**
     * Getter method for the name of the book. 
     * @return The name of the book.
     */

    public String getNameofBook() {
        return nameofBook;
    }

    /**
     * Method to get the size of an address book.
     * @return The size of the book.
     */

    public int bookSize() {
        return people.size();
    }

    /**
     * Method to add a person to the list of people.
     * @param p The person we want to add.
     */

    public void addPerson(Person p) {
        people.add(p);
    }

    /**
     * Getter method for a list of contacts.
     * @return The list of contacts.
     */

    public ArrayList<Person> getPeople() {
        return people;
    }

    /**
     * Getter method for the index of a person using the name of said person.
     * @param name The name of the person.
     * @return Returns the index of the contact if it exists, otherwise -1.
     */

    public int getIndexofContact(String name) {
        for (Person person : people) {
            if (person.getNameofPerson().equals(name)) {
                return people.indexOf(person);
            }
        }
        return -1;
    }

    /**
     * Getter for contact at a certain index.
     * @param index The index of the contact we want.
     * @return Returns the contact at that index.
     */

    public Person getPersonAtIndex(int index) {
        return people.get(index);
    }
}
