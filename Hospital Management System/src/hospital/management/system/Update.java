package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Update extends JFrame {

    JTextField textFieldR, textFieldInTime, depositField, depositField1;
    JComboBox<String> genderBox;
    JButton searchButton, updateButton, backButton;

    Update() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 5, 940, 490);
        panel.setBackground(new Color(90, 156, 163));
        add(panel);

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image = i.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon i1 = new ImageIcon(image);
        JLabel label = new JLabel(i1);
        label.setBounds(500, 60, 300, 300);
        panel.add(label);

        JLabel label1 =  new JLabel("Update Patient Details");
        label1.setBounds(124, 11, 268, 25);
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(label1);

        JLabel nameLabel = new JLabel("Name ");
        nameLabel.setBounds(50, 100, 100, 20);
        panel.add(nameLabel);

        Choice choice = new Choice();
        choice.setBounds(163,100,100,25);
        panel.add(choice);

        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from Patient_Info");
            while(resultSet.next())
            {
                choice.add(resultSet.getString("Name"));
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }

        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setBounds(50, 140, 100, 20);
        panel.add(genderLabel);

        genderBox = new JComboBox<>(new String[]{"Male", "Female"});
        genderBox.setBounds(160, 140, 200, 20);
        panel.add(genderBox);

        JLabel roomLabel = new JLabel("Room Number");
        roomLabel.setBounds(50, 180, 150, 20);
        panel.add(roomLabel);

        textFieldR = new JTextField();
        textFieldR.setBounds(160, 180, 200, 20);
        panel.add(textFieldR);

        JLabel timeLabel = new JLabel("In-Time");
        timeLabel.setBounds(50, 220, 100, 20);
        panel.add(timeLabel);

        textFieldInTime = new JTextField();
        textFieldInTime.setBounds(160, 220, 200, 20);
        panel.add(textFieldInTime);

        JLabel depositLabel = new JLabel("Amount Paid (Rs)");
        depositLabel.setBounds(50, 260, 120, 20);
        panel.add(depositLabel);

        depositField = new JTextField();
        depositField.setBounds(160, 260, 200, 20);
        panel.add(depositField);

        JLabel depositLabel1 = new JLabel("Amount due (Rs)");
        depositLabel1.setBounds(50, 300, 100, 20);
        panel.add(depositLabel1);

        depositField1 = new JTextField();
        depositField1.setBounds(160, 300, 200, 20);
        panel.add(depositField1);

        JButton check = new JButton("Check");
        check.setBounds(100, 360, 120, 30);
        check.setBackground(Color.ORANGE);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = choice.getSelectedItem();
                String q= "select * from patient_info where Name = '"+id+"'";
                try {
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    if (resultSet.next()) {
                        textFieldR.setText(resultSet.getString("Room_Number"));
                        textFieldInTime.setText(resultSet.getString("Time"));
                        depositField.setText(resultSet.getString("Deposite"));
                    }
                    ResultSet resultSet1 = c.statement.executeQuery("select * from Room where Room_Number = '"+textFieldR.getText()+"'");
                    if (resultSet1.next()) {
                        String price = resultSet1.getString("Price");
                        int amountPaid = Integer.parseInt(price) - Integer.parseInt(depositField.getText());
                        depositField1.setText("" + amountPaid);
                    }
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });
        updateButton  = new JButton("Update");
        updateButton .setBounds(240, 360, 120, 30);
        updateButton .setBackground(Color.ORANGE);
        panel.add(updateButton );
        updateButton .addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    conn c = new conn();
                    String name = choice.getSelectedItem();
                    String room = textFieldR.getText();
                    String time = textFieldInTime.getText();
                    String amountPaid = depositField.getText();

                    // Update patient information in the Patient_Info table
                    String query = "update patient_info set Room_Number = '"+room+"', Time = '"+time+"', Deposite = '"+amountPaid+"' where Name = '"+name+"'";
                    c.statement.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Patient details updated successfully.");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error updating patient details.");
                }

                // Close the window after updating
                setVisible(false);
            }
        });
        JButton back = new JButton("Back");
        back.setBounds(380, 360, 120, 30);
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
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Update();
    }
}
