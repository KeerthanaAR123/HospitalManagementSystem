package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class All_Patient_Info extends JFrame {
    JTable table;

    All_Patient_Info() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 5, 990, 590);
        panel.setBackground(new Color(109, 164, 170));
        add(panel);

        // Set up the JTable
        JTable table = new JTable();
        table.setBounds(10, 40, 880, 550);
        table.setBackground(new Color(109, 164, 170));
        table.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(table);


        try {
            conn c = new conn();
            String q = "SELECT * FROM PATIENT_INFO";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }


        JLabel label1 = new JLabel("Patient ID");
        label1.setBounds(12, 11, 100, 14);
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label1);

        JLabel label2 = new JLabel("Number ");
        label2.setBounds(130, 11, 200, 14);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label2);


        JLabel label31 = new JLabel("Name");
        label31.setBounds(245, 11, 200, 14);
        label31.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label31);



        JLabel label4 = new JLabel("Gender");
        label4.setBounds(355, 11, 200, 14);
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label4);



        JLabel label5 = new JLabel("Disease");
        label5.setBounds(465, 11, 200, 14);
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label5);

        JLabel label3 = new JLabel("Room");
        label3.setBounds(570, 11, 200, 14);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label3);


        JLabel label33 = new JLabel("Time");
        label33.setBounds(690, 11, 200, 14);
        label33.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label33);


        JLabel label32 = new JLabel("Deposit");
        label32.setBounds(800, 11, 200, 14);
        label32.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label32);


        JButton back = new JButton("Back");
        back.setBounds(300, 300, 120, 30);
        back.setBackground(Color.ORANGE);
        back.setForeground(Color.BLACK);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });



        setSize(950, 550);
        setLocation(300, 100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new All_Patient_Info();
    }
}
