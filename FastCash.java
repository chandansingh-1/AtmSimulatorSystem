package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JLabel heading;
    JButton b1, b2, b3, b4, b5, b6, b7;
    String pin;

    FastCash(String pin) {
        this.pin = pin;
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("AtmSimulatorSystem/icons/bankImg.jpg"));
        Image imageBack = img.getImage().getScaledInstance(1380, 760, Image.SCALE_DEFAULT);
        ImageIcon iIcon = new ImageIcon(imageBack);
        JLabel background = new JLabel(iIcon);
        background.setBounds(0,0,1380,760);
        add(background);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("AtmSimulatorSystem/icons/atm1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(820, 740, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(300, 20, 820, 740);
        background.add(l3);

        heading = new JLabel("SELECT WITHDRAWL AMOUNT");
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("System", Font.BOLD, 16));

        b1 = new JButton("Rs 100");
        b2 = new JButton("Rs 500");
        b3 = new JButton("Rs 1000");
        b4 = new JButton("Rs 2000");
        b5 = new JButton("Rs 5000");
        b6 = new JButton("Rs 10000");
        b7 = new JButton("BACK");

        setLayout(null);

        heading.setBounds(190, 60, 300, 30);
        l3.add(heading);

        b1.setBounds(140, 190, 145, 25);
        l3.add(b1);

        b2.setBounds(345, 190, 145, 25);
        l3.add(b2);

        b3.setBounds(140, 225, 145, 25);
        l3.add(b3);

        b4.setBounds(345, 225, 145, 25);
        l3.add(b4);

        b5.setBounds(140, 260, 145, 25);
        l3.add(b5);

        b6.setBounds(345, 260, 145, 25);
        l3.add(b6);

        b7.setBounds(345, 290, 145, 25);
        l3.add(b7);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);

//        setSize(860, 750);
//        setLocation(300, 0);
        setExtendedState(JFrame.MAXIMIZED_BOTH);//full screen frame
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = ((JButton)ae.getSource()).getText().substring(3); //k
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            } String num = "17";
            if (ae.getSource() != b7 && balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insuffient Balance");
                return;
            }

            if (ae.getSource() == b7) {
                this.setVisible(false);
                new Transactions(pin).setVisible(true);
            }else{
                Date date = new Date();
                c.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                    
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new FastCash("").setVisible(true);
    }
}

