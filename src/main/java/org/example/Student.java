package org.example;

import java.io.Serializable;
import java.util.Map;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private String lastName;
    private String groupNumber;
    private Map<String, Integer> examScores;

    public Student(String lastName, String groupNumber, Map<String, Integer> examScores) {
        this.lastName = lastName;
        this.groupNumber = groupNumber;
        this.examScores = examScores;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public Map<String, Integer> getExamScores() {
        return examScores;
    }

    public void setExamScores(Map<String, Integer> examScores) {
        this.examScores = examScores;
    }

    public double calculateAverageScore() {
        return examScores.values().stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    @Override
    public String toString() {
        return "Student{" +
                "lastName='" + lastName + '\'' +
                ", groupNumber='" + groupNumber + '\'' +
                ", examScores=" + examScores +
                '}';
    }
}

