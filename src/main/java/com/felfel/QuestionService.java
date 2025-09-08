package com.felfel;

import com.felfel.repository.QuestionRepository;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class QuestionService {
    private final QuestionRepository repository = new QuestionRepository();
    private final Scanner sc = new Scanner(System.in);

    public void addQuestions() {
        try {
            System.out.println("How many questions do you want to add?");
            int numOfQuestions = sc.nextInt();
            sc.nextLine(); // consume newline

            for (int i = 0; i < numOfQuestions; i++) {
                System.out.println("Enter question " + (i + 1) + ":");
                String qText = sc.nextLine();

                System.out.println("How many options?");
                int numOfOptions = sc.nextInt();
                sc.nextLine(); // consume newline

                String[] options = new String[numOfOptions];
                for (int j = 0; j < numOfOptions; j++) {
                    System.out.println("Enter option " + (j + 1) + ":");
                    options[j] = sc.nextLine();
                }

                System.out.println("Enter the index of the correct option:");
                int correctIndex = sc.nextInt();
                sc.nextLine(); // consume newline

                Question q = new Question(qText, options, correctIndex - 1);
                repository.saveQuestion(q);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            sc.nextLine(); // clear invalid input
        }
    }

    public void removeQuestion(int id) {
        repository.deleteQuestion(id);
        System.out.println("Question removed successfully.");
    }

    public void getQuestion(int index, boolean showAnswer) {
        List<Question> questions = repository.loadQuestions();
        if (index < 0 || index >= questions.size()) {
            System.out.println("Invalid index");
            return;
        }

        Question q = questions.get(index);
        System.out.println((index + 1) + ". " + q.questionText());
        for (int i = 0; i < q.options().length; i++) {
            System.out.println("   " + (i + 1) + ". " + q.options()[i]);
        }
        if (showAnswer) {
            System.out.println("   Correct Option: " + (q.correctOptionIndex() + 1));
        }
    }

    public boolean isEmpty() {
        return repository.loadQuestions().isEmpty();
    }

    public int getScore(Question question, int selectedOptionIndex) {
        return question.correctOptionIndex() == selectedOptionIndex ? 1 : 0;
    }

    public List<Question> getAllQuestions() {
        return repository.loadQuestions();
    }
}