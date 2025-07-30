package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Logout extends JFrame {

    Logout() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 5, 450, 300);  // Increased panel size
        panel.setBackground(new Color(109, 164, 170));
        add(panel);

        // Label for the logout message with adjusted size
        JLabel messageLabel = new JLabel("Are you sure you want to log out?");
        messageLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        messageLabel.setBounds(40, 50, 350, 30);  // Adjusted width for the message
        panel.add(messageLabel);

        // Logout button in orange color
        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(70, 100, 120, 40);
        logoutButton.setBackground(Color.ORANGE);
        logoutButton.setForeground(Color.BLACK);
        panel.add(logoutButton);

        // Cancel button in orange color
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(200, 100, 120, 40);
        cancelButton.setBackground(Color.ORANGE);
        cancelButton.setForeground(Color.BLACK);
        panel.add(cancelButton);

        // Action for the logout button
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
                if (confirmed == JOptionPane.YES_OPTION) {
                    // Exit the application
                    System.exit(0);
                }
            }
        });

        // Action for the cancel button
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // Close the logout window and go back
            }
        });

        // JFrame settings
        setSize(450, 300);  // Increased JFrame size to match the new panel size
        setLocation(400, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Logout(); // Instantiate the Logout class to show the UI
    }
}
