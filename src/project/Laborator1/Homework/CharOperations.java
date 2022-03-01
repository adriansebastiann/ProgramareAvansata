package project.Laborator1.Homework;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * Created by Alexoaie Adrian Sebastian
 * This class is used for all operations with the params
 */
public class CharOperations {

    /**
     * This method takes the letters from params and generate a string which will be used to generate random strings
     * @param input the params sent to main method
     * @return the String containing all letters
     */
    public static String getLettersFromParams(String[] input) {
        String letters = "";
        for(int index = 2; index < input.length; index ++) {
            letters += input[index];
        }
        System.out.println("The letters are: " + letters);
        return letters;
    }

    /**
     * This method generates a random word of p letters and returns it
     * @return the random generated word
     */
    public static String randomWord(String letters, int p) {
        StringBuilder stringBuilder = new StringBuilder(p);
        for (int i = 0; i < p; i++) {
            int index = (int)(letters.length() * Math.random());
            stringBuilder.append(letters.charAt(index));
        }
        return stringBuilder.toString();
    }

    /**
     * This method generates n random words of length p
     * @return The list containing the generated words
     */
    public static List<String> randomWords(String letters, int n, int p) {
        List<String> words = new ArrayList<>();
        for(int index = 0; index < n; index ++) {
            words.add(sortString(randomWord(letters, p)));
        }
        return words;
    }

    /**
     * Method that sorts the letters of a word
     * @param word The word that needs to be sorted
     * @return
     */
    public static String sortString(String word) {
        return word.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }

    /**
     * This method checks if two words, first and second, are neighbors or not
     */
    public static boolean checkIfTwoWordsAreNeighbors(String first, String second) {
        int commonLetters = 0;
        for(int index = 0; index < first.length(); index ++) {
            if(first.charAt(index) == second.charAt(index)) {
                commonLetters ++;
            }
        }
        if(commonLetters == 1) {
            return true;
        } else {
            return false;
        }
    }

}
