package org.example;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class CreateStudentData {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Иванов", "101", new HashMap<>() {{
            put("Математика", 4);
            put("Физика", 5);
            put("Информатика", 5);
        }}));
        students.add(new Student("Петров", "101", new HashMap<>() {{
            put("Математика", 3);
            put("Физика", 4);
            put("Информатика", 4);
        }}));
        students.add(new Student("Сидоров", "102", new HashMap<>() {{
            put("Математика", 5);
            put("Физика", 5);
            put("Информатика", 5);
        }}));
        students.add(new Student("Васильев", "102", new HashMap<>() {{
            put("Математика", 4);
            put("Физика", 4);
            put("Информатика", 4);
        }}));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students_data_java.ser"))) {
            oos.writeObject(students);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

