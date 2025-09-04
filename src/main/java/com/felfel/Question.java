package com.felfel;

public record Question(String questionText, String[] options, int correctOptionIndex) {
}
