package com.queueapp.gui;

import com.queueapp.model.Person;
import com.queueapp.model.QueueServer;
import com.queueapp.util.UserValidator;

import javax.swing.*;
import java.awt.*;

public class TicketWindow extends JFrame {
    private JTextField dniField;
    private JButton requestButton;
    private JLabel statusLabel;

    public TicketWindow() {
        setTitle("Solicita Request");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        dniField = new JTextField();
        requestButton = new JButton("Solicitar Ticket");
        statusLabel = new JLabel("Ingresa tu DNI", SwingConstants.CENTER);

        mainPanel.add(new JLabel("DNI:"));
        mainPanel.add(dniField);
        mainPanel.add(requestButton);

        add(mainPanel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);

        requestButton.addActionListener(e -> requestTicket());
    }

    private void requestTicket() {
        String dni = dniField.getText().trim();
        Person person = UserValidator.validateUser(dni);
        
        if (person != null) {
            if (QueueServer.getInstance().addPerson(person)) {
                statusLabel.setText("Ticket emitido con éxito!");
            } else {
                statusLabel.setText("La cola está llena. Inténtalo más tarde..");
            }
        } else {
            statusLabel.setText("Invalido DNI. Por favor, inténtalo de nuevo.");
        }
        
        dniField.setText("");
    }
}