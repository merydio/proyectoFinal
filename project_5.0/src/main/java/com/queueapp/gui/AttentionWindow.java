package com.queueapp.gui;

import com.queueapp.model.Person;
import com.queueapp.model.QueueServer;

import javax.swing.*;
import java.awt.*;

public class AttentionWindow extends JFrame {
    private JLabel currentPersonLabel;
    private JButton nextButton;

    public AttentionWindow() {
        setTitle("Ventana de atención");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        currentPersonLabel = new JLabel("Nadie en atención", SwingConstants.CENTER);
        nextButton = new JButton("Llamar a la siguiente persona");

        mainPanel.add(currentPersonLabel);
        mainPanel.add(nextButton);

        add(mainPanel);

        nextButton.addActionListener(e -> callNextPerson());
    }

    private void callNextPerson() {
        Person nextPerson = QueueServer.getInstance().getNextPerson();
        if (nextPerson != null) {
            currentPersonLabel.setText("Actual: " + nextPerson.toString());
        } else {
            currentPersonLabel.setText("La cola está vacía");
        }
    }
}