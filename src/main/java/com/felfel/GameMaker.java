package com.felfel;

import java.util.List;
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
        System.out.println("Welcome Game Maker!");

        while (maker) {
            System.out.println("Choose an option:");
            System.out.println("1. Add Questions");
            System.out.println("2. Remove Question");
            System.out.println("3. View Questions");
            System.out.println("4. Exit Maker Mode");
            System.out.println("5. Exit Game");

            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> questionService.addQuestions();
                case 2 -> {
                    System.out.println("Enter the index of the question to remove:");
                    int index = sc.nextInt();
                    questionService.removeQuestion(index);
                    sc.nextLine(); // Consume newline
                }
                case 3 -> {
                    List<Question> questions = questionService.getAllQuestions();
                    if (questions.isEmpty()) {
                        System.out.println("No questions available.");
                    } else {
                        for (int i = 0; i < questions.size(); i++) {
                            questionService.getQuestion(i, true);
                        }
                    }
                }
                case 4 -> {
                    maker = false;
                    System.out.println("Exiting Maker Mode.");
                }
                case 5 -> {
                    System.out.println("Exiting Game Maker. Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}