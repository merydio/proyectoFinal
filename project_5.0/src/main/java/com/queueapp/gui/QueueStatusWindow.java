package com.queueapp.gui;

import com.queueapp.model.QueueServer;

import javax.swing.*;
import java.awt.*;

public class QueueStatusWindow extends JFrame {
    private JLabel queueSizeLabel;
    private Timer updateTimer;

    public QueueStatusWindow() {
        setTitle("Estado de la cola");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        initComponents();
        setLocationRelativeTo(null);
        startUpdateTimer();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        queueSizeLabel = new JLabel("", SwingConstants.CENTER);
        updateQueueInfo();

        mainPanel.add(new JLabel("Estado actual de la cola:", SwingConstants.CENTER));
        mainPanel.add(queueSizeLabel);

        add(mainPanel);
    }

    private void startUpdateTimer() {
        updateTimer = new Timer(1000, e -> updateQueueInfo());
        updateTimer.start();
    }

    private void updateQueueInfo() {
        QueueServer server = QueueServer.getInstance();
        queueSizeLabel.setText(String.format("Personas esperando: %d / %d", 
            server.getQueueSize(), server.getMaxSize()));
    }
}