package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;
import java.util.Date;

public class Patient_discharge extends JFrame {
    JTable table;

    Patient_discharge() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 5, 790, 390);
        panel.setBackground(new Color(90, 156, 163));
        add(panel);


        JLabel label1 = new JLabel("CHECK-OUT");
        label1.setBounds(12, 11, 150, 14);
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        setForeground(Color.BLACK);
        panel.add(label1);

        JLabel label2 = new JLabel("Customer-ID");
        label2.setBounds(30, 80, 150, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        setForeground(Color.BLACK);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(200,80,150,25);
        panel.add(choice);

        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from Patient_Info");
            while(resultSet.next()){
                choice.add(resultSet.getString("number"));
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number");
        label3.setBounds(30, 130, 150, 20);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        setForeground(Color.BLACK);
        panel.add(label3);


        JLabel RN = new JLabel();
        RN.setBounds(200, 130, 150, 20);
        RN.setFont(new Font("Tahoma", Font.BOLD, 14));
        setForeground(Color.BLACK);
        panel.add(RN);

        JLabel label5 = new JLabel("In Time");
        label5.setBounds(30, 180, 150, 20);
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        setForeground(Color.BLACK);
        panel.add(label5);

        JLabel INTIME = new JLabel();
        INTIME.setBounds(200, 180, 250, 20);
        INTIME.setFont(new Font("Tahoma", Font.BOLD, 14));
        setForeground(Color.BLACK);
        panel.add(INTIME);

        JLabel label51 = new JLabel("Out Time");
        label51.setBounds(30, 230, 150, 20);
        label51.setFont(new Font("Tahoma", Font.BOLD, 14));
        setForeground(Color.BLACK);
        panel.add(label51);


        Date date = new Date();
        JLabel OUTTIME = new JLabel(""+date);
        OUTTIME.setBounds(200, 230, 250, 20);
        OUTTIME.setFont(new Font("Tahoma", Font.BOLD, 14));
        setForeground(Color.BLACK);
        panel.add(OUTTIME);

        JButton discharge = new JButton("Discharge");
        discharge.setBounds(30,300,120,30);
        discharge.setBackground(Color.orange);
        discharge.setForeground(Color.black);
        panel.add(discharge);
        discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
               try{
                   c.statement.executeUpdate("delete from Patient_Info where number = '"+choice.getSelectedItem()+"'");
                   c.statement.executeUpdate("Update room set Availability = 'Available' where room_no = '"+ RN.getText()+"'");
                   JOptionPane.showMessageDialog(null,"Done");
                   setVisible(false);
               }catch(Exception E ){
                   E.printStackTrace();
               }
            }
        });

        JButton Check = new JButton("Check");
        Check.setBounds(170,300,120,30);
        Check.setBackground(Color.orange);
        Check.setForeground(Color.black);
        panel.add(Check);
        Check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                try{
                    ResultSet resultSet = c.statement.executeQuery("select * from Patient_Info where number = '" +choice.getSelectedItem()+"'");
                    while (resultSet.next())
                    {
                        RN.setText(resultSet.getString("Room_Number"));
                        INTIME.setText(resultSet.getString("Time"));
                    }


                }catch(Exception E)
                {
                    E.printStackTrace();
                }
            }
        });

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

        // Frame settings
        setUndecorated(true);
        setSize(800, 400);
        setLocation(400, 250);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Patient_discharge();
    }
}
