package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SessionData {
    private List<Student> students;

    public SessionData() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public Map<String, Double> calculateAverageScoresByGroup() {
        return students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGroupNumber,
                        Collectors.averagingDouble(Student::calculateAverageScore)
                ));
    }

    public List<Map.Entry<String, Double>> getGroupsSortedByAverageScore() {
        return calculateAverageScoresByGroup().entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .collect(Collectors.toList());
    }
}

