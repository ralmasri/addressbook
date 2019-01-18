package edu.kit.informatik;

import java.util.*;

/**
 * A class with switch statement to recognize different commands and implement
 * them.
 * 
 * @author Rakan Zeid Al Masri
 * @version 1.0
 */

public class CommandsInAction {

    /**
     * Method to run my program.
     */

    public static void start() {
        Commands c = new Commands();
        String input = Terminal.readLine();
        while (!input.equals("quit")) {
            String[] data = input.split(" ", 2);
            ArrayList<String> listofdata = new ArrayList<String>(Arrays.asList(data[1].split(",")));
            switch (data[0]) {
            case "add-addressbook":
                String nameofBook = listofdata.get(0);
                c.addBook(nameofBook);
                break;
            case "remove-addressbook":
                String nameofBook1 = listofdata.get(0);
                c.removeBook(nameofBook1);
                break;
            case "add-contact":
                String nameofBook2 = listofdata.get(0);
                String nameofContact = listofdata.get(1);
                String email = listofdata.get(2);
                String phone = listofdata.get(3);
                c.addPerson(nameofBook2, nameofContact, email, phone);
                break;
            case "remove-contact":
                String nameofContact1 = listofdata.get(0);
                int id = Integer.parseInt(listofdata.get(1));
                c.removePerson(nameofContact1, id);
                break;
            case "print-addressbook":
                String nameofBook3 = listofdata.get(0);
                c.print(nameofBook3);
                break;
            case "quit":
                break;
            default:
                Terminal.printError("command not found");
                break;
            }
            input = Terminal.readLine();
        }
    }
}
