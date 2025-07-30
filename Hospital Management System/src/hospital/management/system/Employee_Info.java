package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class Employee_Info extends JFrame {
    JTable table;

    Employee_Info() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 5, 990, 590);
        panel.setBackground(new Color(109, 164, 170));
        add(panel);

        // Set up the JTable
        JTable table  = new JTable();
        table.setBounds(10, 34, 1000, 450);
        table.setBackground(new Color(109, 164, 170));
        table.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(table);

        // Fetch employee data from the database
        try {
            conn c = new conn();
            String q = "select * from EMP_INFO"; // Assuming you have an 'employee' table
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set up the labels for the JTable headers
        JLabel label1 = new JLabel("Employee ID");
        label1.setBounds(10, 15, 200, 25);
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label1);

        JLabel label2 = new JLabel("Name");
        label2.setBounds(180, 15, 200, 25);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label2);


        JLabel label3 = new JLabel("Department");
        label3.setBounds(340, 15, 200, 25);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label3);


        JLabel label21 = new JLabel("Number");
        label21.setBounds(510, 15, 200, 25);
        label21.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label21);

        JLabel label4 = new JLabel("Position");
        label4.setBounds(675, 15, 400, 25);
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label4);

        JLabel label5 = new JLabel("Salary");
        label5.setBounds(845, 10,200, 25);
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label5);


        // Back button to return to the previous screen
        JButton back = new JButton("Back");
        back.setBounds(550,510,200,30);
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
        setSize(1300, 750);
        setLocation(300, 100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Employee_Info();
    }
}
