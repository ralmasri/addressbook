package edu.kit.informatik;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A class with methods to check if certain elements are in accordance with the
 * restrictions posed in the exercise sheet.
 * 
 * @author Rakan Zeid Al Masri
 * @version 1.0
 *
 */

public class InputValidity {

    /**
     * A method to check whether the name is in accordance with the rules of the
     * exercise sheet.
     * 
     * @param name The name to be checked
     * @return true if the name matches the pattern, false otherwise.
     */

    public static boolean isNameValid(String name) {
        String regex = "[a-z]+";
        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(name);
        return matcher.matches();
    }

    /**
     * A method to check whether a book already exists.
     * 
     * @param b The book to be checked.
     * @return true of the book already exists, false otherwise.
     */

    public static boolean doesBookExist(Book b) {
        return ListofBooks.getBooks().contains(b);
    }

    /**
     * Method to check if a person is already registered by iterating through the
     * list.
     * 
     * @param p The person to check for.
     * @return true if person exists, false otherwise.
     */

    public static boolean doesPersonExist(Person p) {
        for (Book book : ListofBooks.getBooks()) {
            if (book.getPeople().contains(p)) {
                return true;
            }
        }
        return false;
    }

    /**
     * A method to check whether the email matches the pattern.
     * 
     * @param email email to be checked.
     * @return true if the email matches the pattern, false otherwise.
     */

    public static boolean isEmailValid(String email) {
        String regex1 = "[a-z]+@[a-z]+\\.([a-z]{2,4})";
        Pattern p1 = Pattern.compile(regex1);
        Matcher matcher1 = p1.matcher(email);
        return matcher1.matches();
    }

    /**
     * A method to check whether the phone number matches the pattern and obeys
     * restriction.
     * 
     * @param phonenum phone number to be checked.
     * @return true if phone number matches the pattern and is between 1 and 15
     *         digits.
     */

    public static boolean isPhoneNumValid(String phonenum) {
        String regex2 = "[0-9]+";
        Pattern p2 = Pattern.compile(regex2);
        Matcher matcher2 = p2.matcher(phonenum);
        return matcher2.matches() && (phonenum.length() >= 1) && (phonenum.length() <= 15) && (phonenum.length() >= 1);
    }
}
