package project.Laborator1.Homework;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * Created by Adrian on 26.02.2022
 */
public class MainPart {

    public static void main(String[] args) {

        /**
         * Here we print the params of the function
         */
        long startTime = System.currentTimeMillis();
        for(String arg : args) {
            System.out.println(arg);
        }

        /**
         * Initial variables that we need to solve the problem
         */
        int n = 0,
            p = 0;
        String letters = "";
        List<String> words = new ArrayList<>();


        /**
         * Here we validate the arguments
         * If they are valid we get the values and run the program correctly
         */
        if(ValidateArguments.validateArgumentsList(args)) {
            System.out.println("You are good to go!");
            n = Integer.parseInt(args[0]);
            p = Integer.parseInt(args[1]);
            letters = CharOperations.getLettersFromParams(args);
            words = CharOperations.randomWords(letters, n, p);
        } else {
            System.out.println("Invalid list of arguments, change the input");
        }

        /**
         * Here we try the basic functionalities of the program
         */
        testFunctionalities(letters, n, p);

        /**
         * We call the boolean matrix function to print it
         */
        System.out.println("The boolean matrix is:");
        boolean[][] neighborsMatrix = createBooleanMatrixOfNeighbors(words, n);
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n; j ++) {
                System.out.print(neighborsMatrix[i][j] + " ");
            }
            System.out.println("");
        }

        /**
         * We instantiate an array of MyList and according to the boolean matrix and the list of words
         * We fill the data members of each structure
         */
        MyList[] myDataStructure = generateTheListOfNeighborsForEachWord(createBooleanMatrixOfNeighbors(words, n), words, n);

        /**
         * Here is printed each words and his neighbors
         */
        for(int i = 0; i < n; i ++) {
            System.out.println(words.get(i) + " has the following neighbors " + myDataStructure[i].getMyList());
        }

        /**
         * We display the execution time making the difference between the time we start the execution
         * and the time the program finished then we divide that result with 1000 to obtain the seconds
         */
        long endTime = System.currentTimeMillis();
        System.out.println("The execution time is: " + (endTime - startTime) / 1000.0 + " seconds");

    }

    /**
     * This method tries all the basic functionalities of the project
     * Create some random words and print them
     */
    public static void testFunctionalities(String letters, int n, int p) {
        System.out.println("The letters are: " + letters );
        String random = CharOperations.randomWord(letters, p);
        System.out.println("The generated string is: " + random);
        System.out.println("The generated and sorted string is: " + CharOperations.sortString(random));
        System.out.println(CharOperations.randomWords(letters, n, p));
    }

    /**
     * Here we create the neighbors boolean matrix based on the list with words
     * Indexes are very important so keep that in mind
     * @param words the words to check if they are neighbors
     * @param size the number of words generated
     * @return the boolean matrix created, if a position is true it means that the word i is neighbor with the word j from the list
     */
    public static boolean[][] createBooleanMatrixOfNeighbors(List<String> words, int size) {
        boolean[][] neighbors = new boolean[size][size];
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.size(); j++) {
                if (CharOperations.checkIfTwoWordsAreNeighbors(words.get(i), words.get(j))) {
                    neighbors[i][j] = true;
                } else {
                    neighbors[i][j] = false;
                }
            }
        }
        return neighbors;
    }

    /**
     * Here we generate the list of instances of MyList class, for every word we'll know his neighbors
     * @param neighbors this is the boolean matrix, it says who is neighbor with who
     * @param words this is the list of words, we'll need it to populate the MyList array
     * @param size the number of words generated
     * @return the list with MyList instances which contains the neighbors for the every word
     */
    public static MyList[] generateTheListOfNeighborsForEachWord(boolean neighbors[][], List<String> words, int size) {
        MyList[] myDataStructure = new MyList[size];
        for(int i = 0; i < size; i ++) {
            myDataStructure[i] = new MyList();
        }
        for(int i = 0; i < words.size(); i ++) {
            for(int j = 0; j < words.size(); j ++) {
                if(neighbors[i][j]) {
                    myDataStructure[i].addElementToList(words.get(j));
                }
            }
        }
        return myDataStructure;
    }
}
