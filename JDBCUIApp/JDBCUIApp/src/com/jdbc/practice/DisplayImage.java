package com.jdbc.practice;

import java.sql.Connection;

import javax.swing.*;

public class DisplayImage extends JFrame {
    public static void main(String[] args) {
        Connection con = ConnectionProvider.getConnection();
        DisplayImage di = new DisplayImage();

        // Set frame properties
        di.setSize(500, 500);

        // Show frame in center of screen
        di.setLocationRelativeTo(null);

        // Set Window title
        di.setTitle("Display Image");

        // Add text field
        JTextField textField = new JTextField();
        textField.setBounds(50, 50, 150, 20);

        // Add button
        JButton button = new JButton("Show Image");
        button.setBounds(50, 100, 120, 30);

        // Add label to display image
        JLabel label = new JLabel();
        label.setBounds(90, 350, 50, 50);

        // Add components to frame
        di.add(textField);
        di.add(button);
        di.add(label);

        // Add action listener to button
        button.addActionListener(e -> {
            // Get image id from text field
            int id = Integer.parseInt(textField.getText());

            // Get image icon from database
            ImageIcon icon = FetchImage.getImageIconById(id, con);

            // Set image icon to label
            if (icon == null) {
                JOptionPane.showMessageDialog(di, "Image not found");
            } else {
                label.setIcon(icon);
            }
        });

        // Dipslay components on frame
        di.setVisible(true);

        // Set default close operation
        di.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
