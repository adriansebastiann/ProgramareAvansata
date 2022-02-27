package project.Laborator1.Compulsory;

public class Utils {

    /**
     * This class is the "brain" of the task, it contains all the important methods
     * The first method was build to print the wonderful message "Hello world!"
     */
    public static void printHelloWorld() {
        System.out.println("Hello world!");
    }

    /**
     * This method was build to split the bigger task into smaller ones
     * @param n this method is used to calculate the sum of the digits of the n number until the sum becomes one digit
     * @return this method returns that calculated sum, it is useful to the next method
     */
    static int digSum(int n) {
        int sum = 0;
        while(n > 0 || sum > 9) {
            if(n == 0) {
                n = sum;
                sum = 0;
            }
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    /**
     * This method generates a random number, then, for that number is called the "digitSum"
     * @return the method returns the sum of that random generated number
     */
    public static int generateRandomIndex() {
        int generatedIndex = 0;
        int n = (int) (Math.random() * 1_000_000);
        n = (n * 3 + 0b10101 + 0xFF) * 6;
        while(n > 0 || generatedIndex > 9) {
            if(n == 0) {
                n = generatedIndex;
                generatedIndex = 0;
            }
            generatedIndex += n % 10;
            n /= 10;
        }
        return generatedIndex;
    }
}