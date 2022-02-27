package project.Laborator1.Homework;

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
         * Here we validate the arguments and create a new instance of CharOperations
         */
        if(ValidateArguments.validateArgumentsList(args)) {
            System.out.println("Valid list of arguments");
            CharOperations charOperations = new CharOperations(args);
        } else {
            System.out.println("Invalid list of arguments");
        }

        /**
         * Some tests to check the functionality of the methods
         */
        System.out.println("The letters are: " + CharOperations.letters );
        String random = CharOperations.randomWord();
        System.out.println("The generated string is: " + random);
        System.out.println("The generated and sorted string is: " + CharOperations.sortString(random));
        System.out.println(CharOperations.randomWords());

        /**
         * Create a list of random words and check if they truly are
         * Then fill the boolean matrix
         *
         */
        List<String> words = CharOperations.randomWords();
        int size = parseInt(args[0]);
        boolean[][] neighbors = new boolean[size][size];

        for(int i = 0; i < words.size(); i ++) {
            for(int j = 0; j < words.size(); j ++) {
                if(CharOperations.checkIfTwoWordsAreNeighbors(words.get(i), words.get(j))) {
                    neighbors[i][j] = true;
                } else {
                    neighbors[i][j] = false;
                }
            }
        }

        /**
         * We display the boolean matrix
         */
        for(int i = 0; i < words.size(); i ++) {
            for(int j = 0; j < words.size(); j ++) {
                System.out.print(neighbors[i][j] + " ");
            }
            System.out.println("");
        }

        /**
         * We instantiate an array of MyList and according to the boolean matrix and the list of words
         * We fill the data members of each structure
         */
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

        /**
         * Here is printed each words and his neighbors
         */
        for(int i = 0; i < size; i ++) {
            System.out.println(words.get(i) + " has the following neighbors " + myDataStructure[i].getMyList());
        }

        /**
         * We display the execution time making the difference between the time we start the execution
         * and the time the program finished then we divide that result with 1000 to obtain the seconds
         */
        long endTime = System.currentTimeMillis();
        System.out.println("The execution time is: " + (endTime - startTime) / 1000.0 + " seconds");

    }
}
