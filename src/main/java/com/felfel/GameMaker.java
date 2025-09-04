package com.felfel;

import java.util.Scanner;

public class GameMaker {
    QuestionService qs ;
    Scanner sc = new Scanner(System.in);
    public GameMaker(QuestionService Qs)
    {
        this.qs= Qs;
        MakerMode();
    }
    private void MakerMode(){
        boolean Maker = true;
        System.out.println("Welcome Game Maker!");
        while (Maker)
        {
            System.out.println("Choose an option:");
            System.out.println("1. Add Questions");
            System.out.println("2. Remove Question");
            System.out.println("3. View Questions");
            System.out.println("4. Exit Maker Mode");
            System.out.println("5. Exit Game");
            int choice = sc.nextInt();
            switch (choice)
            {
                case 1:
                    qs.addQuestions();
                    break;
                case 2:
                    System.out.println("Enter the index of the question to remove:");
                    int index = sc.nextInt() - 1;
                    qs.removeQuestion(index);
                    sc.nextLine(); // Consume newline
                    break;
                case 3:
                    if (qs.isEmpty()) {
                        System.out.println("No questions available.");
                        break;
                    }
                    for (int i = 0; i < qs.question.size(); i++) {
                        qs.getQuestion(i,true);
                    }
                    break;
                case 4:
                    Maker = false;
                    System.out.println("Exiting Maker Mode.");
                    break;
                case 5:
                    System.out.println("Exiting Game Maker. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
