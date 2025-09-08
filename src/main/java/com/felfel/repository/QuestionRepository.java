package com.felfel.repository;

import com.felfel.db.DatabaseManager;
import com.felfel.Question;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionRepository {
    private static final String SAVE = "INSERT INTO questions (question, options, answer_index) VALUES (?, ?, ?)";
    private static final String DELETE = "DELETE FROM questions WHERE id = ?";
    private static final String LOAD_ALL = "SELECT * FROM questions";

    public void saveQuestion(Question q) {
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SAVE)) {

            stmt.setString(1, q.questionText());
            Array optionsArray = conn.createArrayOf("text", q.options());
            stmt.setArray(2, optionsArray);
            stmt.setInt(3, q.correctOptionIndex());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("❌ Error saving question: " + e.getMessage());
        }
    }

    public List<Question> loadQuestions() {
        List<Question> questions = new ArrayList<>();
        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(LOAD_ALL)) {

            while (rs.next()) {
                String text = rs.getString("question");
                Array optionsArray = rs.getArray("options");
                String[] options = (String[]) optionsArray.getArray();
                int correctIndex = rs.getInt("answer_index");

                questions.add(new Question(text, options, correctIndex));
            }
        } catch (SQLException e) {
            System.err.println("❌ Error loading questions: " + e.getMessage());
        }
        return questions;
    }

    public void deleteQuestion(int id) {
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(DELETE)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("❌ Error deleting question: " + e.getMessage());
        }
    }
}