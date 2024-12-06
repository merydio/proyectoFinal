package com.queueapp;

import com.queueapp.gui.AttentionWindow;
import com.queueapp.gui.QueueStatusWindow;
import com.queueapp.gui.TicketWindow;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create and show the main windows
            TicketWindow ticketWindow = new TicketWindow();
            AttentionWindow attentionWindow = new AttentionWindow();
            QueueStatusWindow statusWindow = new QueueStatusWindow();

            // Position windows
            ticketWindow.setLocation(100, 100);
            attentionWindow.setLocation(500, 100);
            statusWindow.setLocation(300, 300);

            // Make windows visible
            ticketWindow.setVisible(true);
            attentionWindow.setVisible(true);
            statusWindow.setVisible(true);
        });
    }
}