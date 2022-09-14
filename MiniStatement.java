package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener{
 
    JButton exit;
    JLabel miniState;
    MiniStatement(String pin){
        super("Mini Statement");
        setUndecorated(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);//full screen frame
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("AtmSimulatorSystem/icons/bankImg.jpg"));
        Image imageBack = img.getImage().getScaledInstance(1380, 700, Image.SCALE_DEFAULT);
        ImageIcon iIcon = new ImageIcon(imageBack);
        JLabel background = new JLabel(iIcon);
        background.setBounds(0,0,1380,700);
        add(background);
        
        JPanel panel = new JPanel();
        panel.setBounds(20, 20, 400,600);
        panel.setBackground(Color.WHITE);
        background.add(panel);
        panel.setLayout(null);
        
        miniState = new JLabel();
        panel.add(miniState);
        
        JLabel heading = new JLabel("Indian Bank");
        heading.setBounds(150, 20, 100, 20);
        panel.add(heading);
        
        JLabel cardNumber = new JLabel();
        cardNumber.setBounds(20, 80, 300, 20);
        panel.add(cardNumber);
        
        JLabel totalBalance = new JLabel();
        totalBalance.setBounds(20, 400, 300, 20);
        panel.add(totalBalance);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pin+"'");
            while(rs.next()){
                cardNumber.setText("Card Number:    " + rs.getString("cardno").substring(0, 4) + "XXXXXXXX" + rs.getString("cardno").substring(12));
            }
        }catch(Exception e){}
        	 
        try{
            int balance = 0;
            Conn c1  = new Conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank where pin = '"+pin+"'");
            while(rs.next()){
                miniState.setText(miniState.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            totalBalance.setText("Your total Balance is Rs "+balance);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setLayout(null);
        exit = new JButton("Exit");
        panel.add(exit);
        
        exit.addActionListener(this);
        
        miniState.setBounds(20, 140, 400, 200);
        exit.setBounds(20, 500, 100, 25);
    }
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }
    
    public static void main(String[] args){
        new MiniStatement("").setVisible(true);
    }
    
}

