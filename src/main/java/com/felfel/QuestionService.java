package com.felfel;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class QuestionService {
    // This class can be expanded to include methods for managing questions, such as adding, removing, or fetching questions.
 final ArrayList <Question> question= new ArrayList<>();
 Scanner sc = new Scanner(System.in);

    public void addQuestions() {
        // Implementation for adding a question
        try {
            System.out.println("how many questions do you want to add?");
            int numOfQuestions = sc.nextInt();
            for (int i = 0; i < numOfQuestions; i++) {
                System.out.println("enter question " + (i + 1));
                sc.nextLine();
                String qText = sc.nextLine();
                System.out.println("How many options for question " + (i + 1) + "?");
                int numOfOptions = sc.nextInt();
                sc.nextLine();
                String[] options = new String[numOfOptions];
                System.out.println("enter options for question " + (i + 1));
                for (int j = 0; j < options.length; j++) {
                    System.out.println("enter option " + (j + 1));
                    options[j] = sc.nextLine();
                }
                System.out.println("enter the index of the correct option for question " + (i + 1));
                int correctIndex = sc.nextInt();
                question.add(new Question(qText, options, correctIndex - 1));
            }
        }
        catch (InputMismatchException Miss){
            System.out.println("Invalid input. Please try again.");
            sc.nextLine(); // Clear the invalid input
        }
    }

    public void removeQuestion(int index) {
        // Implementation for removing a question
        if (index < 0 || index >= question.size()) {
            System.out.println("Invalid index");
            return;
        }
            question.remove(index);
            System.out.println("Question removed successfully");
    }

    public void getQuestion(int index,boolean showAnswer) {
        if (index < 0 || index >= question.size()) {
            System.out.println("Invalid index");
            return;
        }

        Question q = question.get(index);
        System.out.println((index + 1) + ". " + q.questionText());

        String[] options = q.options();
        for (int j = 0; j < options.length; j++) {
            System.out.println("   " + (j + 1) + ". " + options[j]);
        }
        if (showAnswer){
        System.out.println("   Correct Option: " + (q.correctOptionIndex() + 1));}
    }
    public boolean isEmpty() {
        return question.isEmpty();
    }
    public int getScore(Question question, int selectedOptionIndex) {
        return question.correctOptionIndex() == selectedOptionIndex ? 1 : 0;
    }
}
