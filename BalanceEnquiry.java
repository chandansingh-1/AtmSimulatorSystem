package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.util.*;

class BalanceEnquiry extends JFrame implements ActionListener {

    JButton back;
    JLabel currentBalance;
    String pin;

    BalanceEnquiry(String pin) {
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
        JLabel label = new JLabel(i3);
        label.setBounds(300, 20, 820, 740);
        background.add(label);

        currentBalance = new JLabel();
        currentBalance.setForeground(Color.BLACK);
        currentBalance.setFont(new Font("System", Font.BOLD, 16));

        back = new JButton("BACK");

        setLayout(null);

        currentBalance.setBounds(190,60,300,30);
        label.add(currentBalance);

        back.setBounds(345,290,145,25);
        label.add(back);
        int balance = 0;
        try{
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+pin+"'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){}
        
        currentBalance.setText("Current Balance: Rs "+balance);

        back.addActionListener(this);

        
        setExtendedState(JFrame.MAXIMIZED_BOTH);//full screen frame
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pin).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }
}
