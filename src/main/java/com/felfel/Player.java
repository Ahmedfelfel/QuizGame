package com.felfel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
    Scanner sc = new Scanner(System.in);
    QuestionService qs ;
    public Player(QuestionService qs)
    {
        this.qs = qs;
        System.out.println("Welcome Player!");
        System.out.println("choose an option:");
        System.out.println("1. Start Quiz");
        System.out.println("2. Exit");
        int choice = sc.nextInt();
        switch (choice)
        {
            case 1:
                startQuiz();
                break;
            case 2:
                System.out.println("Exiting the game. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }

    }
    private void startQuiz() {
        if (qs.isEmpty()) {
            System.out.println("No questions available. Please ask the Game Maker to add questions first.");
            return;
        }
        try {
        int score = 0;
        for (int i = 0; i < qs.question.size(); i++) {
            qs.getQuestion(i,false);
            System.out.println("Enter your answer (option number):");
            int selectedOptionIndex = sc.nextInt() - 1;
            score += qs.getScore(qs.question.get(i), selectedOptionIndex);
        }
        System.out.println("Quiz Over! Your total score is: " + score + "/" + qs.question.size());
        retake();
    }
        catch (InputMismatchException Miss){
            System.out.println("Invalid input. Please try again.");
            sc.nextLine(); // Clear the invalid input
        }
    }
    private void retake()
    {
        try {
            System.out.println("Do you want to retake the quiz?");
            System.out.println("1. yes");
            System.out.println("2. no");
            int responseInt = sc.nextInt();
            switch (responseInt)
            {
                case 1:
                    startQuiz();
                    break;
                case 2:
                    System.out.println("Thank you for playing! Goodbye!");
                    return;
                default:
                    System.out.println("Invalid input. Please choose 'yes' or 'no'.");
                    retake();
                    break;
            }

        }
        catch (InputMismatchException Miss){
            System.out.println("Invalid input. Please try again.");
            sc.nextLine(); // Clear the invalid input
        }
    }
}
