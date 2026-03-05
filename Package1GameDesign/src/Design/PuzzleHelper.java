package Design;

import java.util.Scanner;

public class PuzzleHelper {

    // Method to ask a single puzzle question and validate the answer
    public static int askPuzzle(String question, int correctAnswer, Scanner scanner) {
        System.out.println(question);
        int answer = scanner.nextInt();

        if (answer == correctAnswer) {
            System.out.println("Correct answer!");
            return 1;
        } else {
            System.out.println("Wrong answer!");
            return 0;
        }
    }
}
