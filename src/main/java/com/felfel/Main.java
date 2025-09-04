package com.felfel;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new java.util.Scanner(System.in);
        QuestionService qs = new QuestionService();
        System.out.println("Hello and welcome to Quiz Game!");
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. player ");
            System.out.println("2. Game Maker");
            System.out.println("3. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Player player = new Player(qs);
                    break;
                case 2:
                    GameMaker gameMaker = new GameMaker(qs);
                    break;
                case 3:
                    System.out.println("Exiting the game. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}