package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainFrame extends JFrame {

    private SessionData sessionData;
    private JFileChooser fileChooser;

    public MainFrame() {
        sessionData = new SessionData();
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Student Session Data Manager");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Создание меню
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");

        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(new JSeparator());
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        // Добавление обработчиков событий
        openItem.addActionListener(e -> openFile());
        saveItem.addActionListener(e -> saveFile());
        exitItem.addActionListener(e -> System.exit(0));

        // Компонент выбора файла
        fileChooser = new JFileChooser();

        // Другие компоненты интерфейса...
    }

    private void openFile() {
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            List<Student> students = FileHandler.loadStudentsFromFile(fileChooser.getSelectedFile().getAbsolutePath());
            sessionData.getStudents().clear();
            sessionData.getStudents().addAll(students);
            // Обновить интерфейс с новыми данными
        }
    }

    private void saveFile() {
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            FileHandler.saveStudentsToFile(sessionData.getStudents(), fileChooser.getSelectedFile().getAbsolutePath());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}

