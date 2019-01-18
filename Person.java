package edu.kit.informatik;

/**
 * A Person class that implements the interface Comparable.
 * 
 * @author Rakan Zeid Al Masri
 * @version 1.0
 */

public class Person implements Comparable<Person> {
    private static int idc = 1;
    private String nameofPerson;
    private String phonenum;
    private String email;
    private int id;
    
    /**
     * Constructor for person.
     * @param nameofPerson The name of the person.
     * @param phonenum The phone number of the person.
     * @param email The email of the person.
     * @param id The id of the person.
     */
    
    public Person(String nameofPerson, String phonenum, String email, int id) {
        this.nameofPerson = nameofPerson;
        this.phonenum = phonenum;
        this.email = email;
        this.id = idc;
        idc++;
    }

    /**
     * Another Constructor for person.
     * @param nameofPerson The name of the person.
     * @param phonenum The phone number of the person.
     * @param email The email of the person.
     */
    
    public Person(String nameofPerson, String phonenum, String email) {
        this.nameofPerson = nameofPerson;
        this.phonenum = phonenum;
        this.email = email;
        id = idc;
        idc++;
    }

    /**
     * Constructor for a person/contact.
     * @param nameofPerson The name of the contact.
     * @param id The id of the contact.
     */
    
    public Person(String nameofPerson, int id) {
        /**
         * name of the person and id that gets incremented by 1 for each person.
         */
        
        this.nameofPerson = nameofPerson;
        this.id = idc;
        idc++;
    }

    /**
     * Getter method for id.
     * @return id Returns the id.
     */
    
    public int getId() {
        return id;
    }

    /**
     * Getter method for the name of the person.
     * @return Returns the name of the person.
     */
    
    public String getNameofPerson() {
        return nameofPerson;
    }

    @Override
    public int compareTo(Person person) {
        return id - person.id;
    }

    @Override
    public String toString() {
        return Commands.idString(id) + "," + nameofPerson + "," + email + "," + phonenum;
    }
}
