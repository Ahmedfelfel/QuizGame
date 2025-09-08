package com.felfel;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Player {
    private final Scanner sc = new Scanner(System.in);
    private final QuestionService questionService;

    public Player(QuestionService qs) {
        this.questionService = qs;
        System.out.println("Welcome Player!");
        System.out.println("Choose an option:");
        System.out.println("1. Start Quiz");
        System.out.println("2. Exit");

        int choice = sc.nextInt();
        switch (choice) {
            case 1 -> startQuiz();
            case 2 -> System.out.println("Exiting the game. Goodbye!");
            default -> System.out.println("Invalid choice. Please try again.");
        }
    }

    private void startQuiz() {
        if (questionService.isEmpty()) {
            System.out.println("No questions available. Please ask the Game Maker to add questions first.");
            return;
        }

        try {
            int score = 0;
            List<Question> questions = questionService.getAllQuestions();

            for (int i = 0; i < questions.size(); i++) {
                Question q = questions.get(i);
                questionService.getQuestion(i, false);
                System.out.println("Enter your answer (option number):");
                int selectedOptionIndex = sc.nextInt() - 1;
                if(selectedOptionIndex < 0 || selectedOptionIndex >= q.options().length) {
                    System.out.println("Invalid option. Moving to the next question.");
                    continue;
                }
                score += questionService.getScore(q, selectedOptionIndex);
            }

            System.out.println("Quiz Over! Your total score is: " + score + "/" + questions.size());
            retake();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            sc.nextLine(); // Clear invalid input
        }
    }

    private void retake() {
        try {
            System.out.println("Do you want to retake the quiz?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int responseInt = sc.nextInt();

            switch (responseInt) {
                case 1 -> startQuiz();
                case 2 -> System.out.println("Thank you for playing! Goodbye!");
                default -> {
                    System.out.println("Invalid input. Please choose 'yes' or 'no'.");
                    retake();
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            sc.nextLine(); // Clear invalid input
        }
    }
}