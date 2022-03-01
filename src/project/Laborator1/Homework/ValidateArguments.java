package project.Laborator1.Homework;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alexoaie Adrian Sebastian
 * We use din class tu validate the params for main methods
 */
public class ValidateArguments {

    /**
     * This method validates if the first two params are integers
     */
    private static boolean validateInteger(String input) {
        try {
            Integer.parseInt(input);
            System.out.println(input + " is a valid integer");
            return true;
        }
        catch (NumberFormatException e) {

            System.out.println(input + " is not a valid integer");
        }
        return false;
    }

    /**
     * This method verifies if the numbers of params is bigger than 4
     * This is a good scenario for the program to work
     * @param input is the list of the params
     * @return the method returns true if the number is bigger than 3 and false otherwise
     */
    private static boolean validNumberOfArguments(String[] input) {
        return input.length > 3;
    }

    /**#
     * Returns true if the characters from the second one ahead are chars
     * @param args the input params
     * @return true if all are letters
     */
    public static boolean theRestOfCharactersAreLetters(String[] args) {
        for(int i = 2; i < args.length; i++) {
            if(!args[i].matches("[a-zA-Z]")) {
                return false;
            }
        }
        return true;
    }

    /**
     * Concatenate the characters from input and returns the string result
     * @param args the input params
     * @return the string formed from letters transmitted
     */
    public static String concatenateLettersFromInput(String[] args) {
        String letters = "";
        for(int i = 2; i < args.length; i++) {
            letters += args[i];
        }
        return letters;
    }

    /**
     * Returns true if all characters of given String are unique
     * @param input
     * @return true if no duplicate characters
     */
    public static boolean isUnique(String input) {
        // Create a Set to insert characters
        Set<Character> set = new HashSet<>();

        // get all characters form String
        char[] characters = input.toCharArray();

        for (Character c : characters) {
            if (!set.add(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Verifies is the characters from a string are unique
     * @param input the input params
     * @return true if the characters from string are unique
     */
    public static boolean theCharactersAreUnique(String input) {
        return isUnique(input);
    }


    /**
     * This method combines the other two
     * @param input the same array of strings with params
     * @return true if conditions are satisfied and false otherwise
     */
    public static boolean validateArgumentsList(String[] input) {
        return validateInteger(input[0]) &&
               validateInteger(input[1]) &&
               !validateInteger(input[2]) &&
                validNumberOfArguments(input) &&
                theRestOfCharactersAreLetters(input) &&
                theCharactersAreUnique(concatenateLettersFromInput(input));
    }

}
