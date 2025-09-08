package com.felfel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameMaker {
    private final QuestionService questionService;
    private final Scanner sc = new Scanner(System.in);

    public GameMaker(QuestionService qs) {
        this.questionService = qs;
        MakerMode();
    }

    private void MakerMode() {
        boolean maker = true;
        System.out.println("🛠️ Welcome Game Maker!");

        while (maker) {
            System.out.println("\nChoose an option:");
            System.out.println("1. ➕ Add Questions");
            System.out.println("2. 🗑️ Remove Question");
            System.out.println("3. 👀 View Questions");
            System.out.println("4. 🔙 Exit Maker Mode");
            System.out.println("5. ❌ Exit Game");

            try {
                int choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1 -> questionService.addQuestions();
                    case 2 -> {
                        System.out.println("Enter the ID of the question to remove:");
                        int id = sc.nextInt();
                        sc.nextLine();
                        questionService.removeQuestion(id);
                    }
                    case 3 -> questionService.displayAllQuestions(true);
                    case 4 -> {
                        maker = false;
                        System.out.println("Exiting Maker Mode...");
                    }
                    case 5 -> {
                        System.out.println("Exiting Game. Goodbye!");
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine(); // clear invalid input
            }
        }
    }
}