package project.Laborator1.Homework;

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

    /**
     * This method combines the other two
     * @param input the same array of strings with params
     * @return true if conditions are satisfied and false otherwise
     */
    public static boolean validateArgumentsList(String[] input) {
        return validateInteger(input[0]) && validateInteger(input[1]) && !validateInteger(input[2]) && validNumberOfArguments(input);
    }

}
