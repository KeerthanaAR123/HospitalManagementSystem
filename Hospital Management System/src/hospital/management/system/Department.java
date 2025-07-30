package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class Department extends JFrame {
    JTable table;

    Department() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 890, 590);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        // Set up the JTable
        JTable table = new JTable();
        table.setBounds(10, 40, 590, 400);
        table.setBackground(new Color(90, 156, 163));
        table.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(table);

        // Fetch data from the database
        try {
            conn c = new conn();
            String q = "select * from department";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }


        JLabel label1 = new JLabel("Department Name");
        label1.setBounds(20, 15, 150, 15);
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label1);

        JLabel label2= new JLabel("Department Phone_NO");
        label2.setBounds(300, 15, 200, 15);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label2);

        // Back button to return to the previous screen
        JButton back = new JButton("Back");
        back.setBounds(550, 470, 120, 30);
        back.setBackground(Color.ORANGE);
        back.setForeground(Color.BLACK);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        // Frame settings
        setUndecorated(true);
        setSize(850, 550);
        setLayout(null);
        setLocation(300, 100);
        setVisible(true);
    }

    public static void main(String args[]) {
        new Department();
    }
}
