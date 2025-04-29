import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        ArrayList<Integer> guessList = new ArrayList<>();
        System.out.println("Welcome to the number prediction game!");
        int randNum = (int)(Math.random() * 100) + 1;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your guess: ");
        int guess = scanner.nextInt();
        guessList.add(guess);

        while (guess != randNum) {
            if (guess > randNum) {
                System.out.println("Please enter a smaller number: ");
            }
            else {
                System.out.println("Please enter a greater number: ");
            }
            guess = scanner.nextInt();
            guessList.add(guess);
        }

        System.out.println("Congarts, true guess! The number was " + randNum);
        System.out.println("Your guesses were: " + guessList);
    }
}
